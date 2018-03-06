package com.sjd.service1.query;

import org.springframework.beans.factory.annotation.Autowired;

import com.sjd.service1.event.TodoCreatedEvent;
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

        log.info("GOT AN EVENT!!");

        Todo todo = new Todo(de.getEvent().getTodo());
        todo.setId(de.getEntityId());

        todoQueryService.save(todo);
    }
}
