package com.johnnyrichard.todo.command;

import lombok.Value;

import java.util.UUID;

@Value(staticConstructor = "of")
public class TodoId {
    private final UUID value;

    public static TodoId create() {
        return new TodoId(UUID.randomUUID());
    }
}
