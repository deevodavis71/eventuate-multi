package com.sjd.service1.query;

import com.sjd.common.event.TodoCreatedEvent;
import com.sjd.common.event.TodoUpdatedEvent;
import com.sjd.common.event.TodoUppercasedEvent;
import com.sjd.service1.backend.command.TodoCommand;
import com.sjd.service1.backend.command.UppercaseTodoCommand;
import com.sjd.service1.backend.domain.TodoAggregate;
import io.eventuate.AggregateRepository;
import io.eventuate.DispatchedEvent;
import io.eventuate.EventHandlerMethod;
import io.eventuate.EventSubscriber;
import lombok.extern.slf4j.Slf4j;

/**
 * User: stevedavis
 * Date: 06/03/2018
 * Time: 19:53
 * Description:
 */
@Slf4j
@EventSubscriber(id = "todoQuerySideEventHandlers-1")
public class TodoQueryWorkflow {

    private TodoQueryService todoQueryService;

    private final AggregateRepository<TodoAggregate, TodoCommand> aggregateRepository;

    public TodoQueryWorkflow(TodoQueryService todoQueryService, AggregateRepository<TodoAggregate, TodoCommand> todoRepository) {

        this.todoQueryService = todoQueryService;
        this.aggregateRepository = todoRepository;

    }

    @EventHandlerMethod
    public void create(DispatchedEvent<TodoCreatedEvent> de) {

        log.info("GOT A CREATE QUERY-VIEW EVENT!!");

        Todo todo = new Todo(de.getEvent().getTodoInfo());
        todo.setId(de.getEntityId());

        todoQueryService.save(todo);

    }

    @EventHandlerMethod
    public void update(DispatchedEvent<TodoUpdatedEvent> de) {

        log.info("GOT A UPDATE QUERY-VIEW EVENT!!");

        Todo todo = new Todo(de.getEvent().getTodoInfo());
        todo.setId(de.getEntityId());
        todo.addMetadata("Updated", "By Steve");

        todoQueryService.save(todo);

        aggregateRepository.update(de.getEntityId(), new UppercaseTodoCommand(de.getEntityId(), de.getEvent().getTodoInfo()));

    }

    @EventHandlerMethod
    public void uppercase(DispatchedEvent<TodoUppercasedEvent> de) {

        log.info("GOT A UPPERCASE QUERY-VIEW EVENT!!");

        Todo todo = new Todo(de.getEvent().getTodoInfo());
        todo.setId(de.getEntityId());
        todo.setTitle(todo.getTitle().toUpperCase());

        todoQueryService.save(todo);

    }
}
