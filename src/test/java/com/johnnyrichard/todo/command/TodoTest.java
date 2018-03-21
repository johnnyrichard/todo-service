package com.johnnyrichard.todo.command;

import com.johnnyrichard.todo.event.TodoCreatedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;

public class TodoTest {

    FixtureConfiguration<Todo> fixture;

    @Before
    public void setUp() {
       fixture = new AggregateTestFixture<>(Todo.class);
    }

    @Test
    public void createTodo() {
        CreateTodoCommand createTodoCommand = new CreateTodoCommand("title", "description");
        TodoCreatedEvent todoCreatedEvent = new TodoCreatedEvent(createTodoCommand.getId(), "title", "description");

        fixture
            .givenNoPriorActivity()
            .when(createTodoCommand)
            .expectEvents(todoCreatedEvent);
    }
}
