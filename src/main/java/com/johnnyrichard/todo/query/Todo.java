package com.johnnyrichard.todo.query;

import com.johnnyrichard.todo.command.TodoId;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
public class Todo {

    @Id
    private TodoId id;
    private String title;
    private String description;
}
