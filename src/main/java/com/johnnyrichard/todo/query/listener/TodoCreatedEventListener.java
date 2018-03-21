package com.johnnyrichard.todo.query.listener;

import com.johnnyrichard.todo.event.TodoCreatedEvent;
import com.johnnyrichard.todo.query.Todo;
import com.johnnyrichard.todo.query.TodoRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TodoCreatedEventListener {

    private final TodoRepository todoRepository;

    @EventHandler
    public void on(TodoCreatedEvent event) {
        todoRepository.save(getTodoFrom(event));
    }

    private Todo getTodoFrom(TodoCreatedEvent event) {
        return new Todo(event.getId(), event.getTitle(), event.getDescription());
    }
}
