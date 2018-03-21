package com.johnnyrichard.todo.query.listener;

import com.johnnyrichard.todo.query.Todo;
import com.johnnyrichard.todo.command.TodoId;
import com.johnnyrichard.todo.event.TodoCreatedEvent;
import com.johnnyrichard.todo.query.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.refEq;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TodoCreatedEventListenerTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoCreatedEventListener listener;


    @Test
    public void addANewTodo() {
        TodoId id = TodoId.create();

        listener.on(new TodoCreatedEvent(id, "title", "description"));

        verify(todoRepository).save(refEq(new Todo(id, "title", "description")));
    }
}
