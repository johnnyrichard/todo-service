package com.johnnyrichard.todo.command;

import com.johnnyrichard.todo.event.TodoCreatedEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Data
@Aggregate
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @AggregateIdentifier
    private TodoId id;
    private String title;
    private String description;

    @CommandHandler
    public Todo(CreateTodoCommand command) {
        apply(new TodoCreatedEvent(command.getId(), command.getTitle(), command.getDescription()));
    }

    @EventSourcingHandler
    public void on(TodoCreatedEvent event) {
        this.id = event.getId();
        this.title = event.getTitle();
        this.description = event.getDescription();
    }

}
