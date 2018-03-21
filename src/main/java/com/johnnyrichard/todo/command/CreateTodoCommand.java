package com.johnnyrichard.todo.command;

import lombok.Getter;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

import static java.util.UUID.randomUUID;

@Getter
public class CreateTodoCommand {
    @TargetAggregateIdentifier
    private final TodoId id;
    private final String title;
    private final String description;

    public CreateTodoCommand(String title, String description) {
        this.id = TodoId.create();
        this.title = title;
        this.description = description;
    }
}
