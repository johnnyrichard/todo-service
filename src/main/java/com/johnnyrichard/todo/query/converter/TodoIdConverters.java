package com.johnnyrichard.todo.query.converter;

import com.johnnyrichard.todo.command.TodoId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class TodoIdConverters {

    public static StringToTodoIdConverter reading() {
        return new StringToTodoIdConverter();
    }

    public static TodoIdToStringConverter writing() {
        return new TodoIdToStringConverter();
    }

    @Component
    @ReadingConverter
    public static class StringToTodoIdConverter implements Converter<String, TodoId> {

        @Override
        public TodoId convert(String value) {
            return TodoId.of(UUID.fromString(value));
        }
    }

    @Component
    @WritingConverter
    public static class TodoIdToStringConverter implements Converter<TodoId, String> {

        @Override
        public String convert(TodoId id) {
            return id.getValue().toString();
        }
    }
}
