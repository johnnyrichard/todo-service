package com.johnnyrichard.todo.query;

import com.johnnyrichard.todo.command.TodoId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, TodoId> {

}
