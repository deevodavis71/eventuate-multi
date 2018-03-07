package com.sjd.service1.query;

import com.sjd.service1.event.TodoCreatedEvent;
import com.sjd.service1.event.TodoUpdatedEvent;
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
@EventSubscriber(id = "todoQuerySideEventHandlers")
public class TodoQueryWorkflow {

    private TodoQueryService todoQueryService;

    public TodoQueryWorkflow(TodoQueryService todoQueryService) {

        this.todoQueryService = todoQueryService;

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

    }
}
