package com.sjd.service2.query;

import com.sjd.common.event.TodoCreatedEvent;
import com.sjd.common.event.TodoUpdatedEvent;
import com.sjd.common.event.TodoUppercasedEvent;
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
@EventSubscriber(id = "todoQuerySideEventHandlers-2")
public class TodoQueryWorkflow {

    @EventHandlerMethod
    public void create(DispatchedEvent<TodoCreatedEvent> de) {

        log.info("GOT A CREATE QUERY-VIEW EVENT!!");

    }

    @EventHandlerMethod
    public void update(DispatchedEvent<TodoUpdatedEvent> de) {

        log.info("GOT A UPDATE QUERY-VIEW EVENT!!");

    }

    @EventHandlerMethod
    public void uppercase(DispatchedEvent<TodoUppercasedEvent> de) {

        log.info("GOT A UPPERCASE QUERY-VIEW EVENT!!");

    }
}
