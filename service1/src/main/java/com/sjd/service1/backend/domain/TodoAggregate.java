package com.sjd.service1.backend.domain;

import java.util.Collections;
import java.util.List;

import com.sjd.service1.backend.command.CreateTodoCommand;
import com.sjd.service1.backend.command.TodoCommand;
import com.sjd.service1.event.TodoCreatedEvent;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;

public class TodoAggregate extends ReflectiveMutableCommandProcessingAggregate<TodoAggregate, TodoCommand> {

    private TodoInfo todoInfo;
    private boolean deleted;

    public List<Event> process(CreateTodoCommand cmd) {

        if (this.deleted) {
            return Collections.emptyList();
        }

        return EventUtil.events(new TodoCreatedEvent(cmd.getTodoInfo()));
    }

    public void apply(TodoCreatedEvent event) {
        this.todoInfo = event.getTodo();
    }

}


