package com.johnnyrichard.todo.event;


import com.johnnyrichard.todo.command.TodoId;
import lombok.Value;
import org.axonframework.serialization.Revision;

@Value
@Revision("1")
public class TodoCreatedEvent {
    private final TodoId id;
    private final String title;
    private final String description;
}
