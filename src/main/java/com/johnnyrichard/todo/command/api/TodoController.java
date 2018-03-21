package com.johnnyrichard.todo.command.api;

import com.johnnyrichard.todo.command.CreateTodoCommand;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@AllArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private CommandGateway commander;

    @PostMapping
    public CompletableFuture<?> postTodos(@RequestBody TodoRequest todoRequest) {
        FutureCallback<CreateTodoCommand, Object> callback = new FutureCallback<>();
        commander.send(new CreateTodoCommand(todoRequest.getTitle(), todoRequest.getDescription()), callback);
        return callback.toCompletableFuture();
    }

}
