package com.johnnyrichard.todo.query.api;

import com.johnnyrichard.todo.command.TodoId;
import com.johnnyrichard.todo.query.Todo;
import com.johnnyrichard.todo.query.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("todos")
@AllArgsConstructor
public class TodosController {

    private TodoRepository todoRepository;

    @GetMapping
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Todo> getTodo(@PathVariable TodoId id) {
        return todoRepository.findById(id);
    }
}
