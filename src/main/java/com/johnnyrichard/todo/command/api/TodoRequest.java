package com.johnnyrichard.todo.command.api;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class TodoRequest {
    private String title;
    private String description;
}
