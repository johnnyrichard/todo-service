package com.johnnyrichard.todo.query.converter;

import com.johnnyrichard.todo.command.TodoId;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.convert.converter.Converter;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoIdToStringConverterTest {

    private Converter<TodoId, String> converter;

    @Before
    public void setUp() {
        converter = TodoIdConverters.writing();
    }

    @Test
    public void testConvertFromTodoIdToString() {
        UUID uuid = UUID.randomUUID();

        String convertedId = converter.convert(TodoId.of(uuid));

        assertThat(convertedId).isEqualTo(uuid.toString());
    }
}
