package com.sjd.service1.backend.domain;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import com.sjd.common.backend.domain.TodoInfo;
import com.sjd.service1.backend.command.CreateTodoCommand;
import com.sjd.service1.backend.command.TodoCommand;
import com.sjd.service1.backend.command.UpdateTodoCommand;
import io.eventuate.AggregateRepository;
import io.eventuate.EntityWithIdAndVersion;

/**
 * User: stevedavis
 * Date: 06/03/2018
 * Time: 19:17
 * Description:
 */
@Service
public class TodoService {

    private final AggregateRepository<TodoAggregate, TodoCommand> aggregateRepository;

    public TodoService(AggregateRepository<TodoAggregate, TodoCommand> todoRepository) {

        this.aggregateRepository = todoRepository;

    }

    public CompletableFuture<EntityWithIdAndVersion<TodoAggregate>> save(TodoInfo todo) {

        return aggregateRepository.save(new CreateTodoCommand(todo));

    }

    public CompletableFuture<EntityWithIdAndVersion<TodoAggregate>> update(String id, TodoInfo newTodo) {

        return aggregateRepository.update(id, new UpdateTodoCommand(id, newTodo));

    }
}
