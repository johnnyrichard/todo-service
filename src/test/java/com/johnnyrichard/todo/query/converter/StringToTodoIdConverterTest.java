package com.johnnyrichard.todo.query.converter;

import com.johnnyrichard.todo.command.TodoId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class StringToTodoIdConverterTest {

    private Converter<String, TodoId> converter;

    @Before
    public void setUp() {
        converter = TodoIdConverters.reading();
    }

    @Test
    public void testConvertFromStringToTodoId() {
        UUID uuid = UUID.randomUUID();

        TodoId todoId = converter.convert(uuid.toString());

        assertThat(todoId).isEqualTo(TodoId.of(uuid));
    }
}
