package com.sjd.service1.backend.domain;

import java.util.Collections;
import java.util.List;

import com.sjd.service1.backend.command.CreateTodoCommand;
import com.sjd.service1.backend.command.TodoCommand;
import com.sjd.service1.backend.command.UpdateTodoCommand;
import com.sjd.service1.backend.command.UppercaseTodoCommand;
import com.sjd.service1.event.TodoCreatedEvent;
import com.sjd.service1.event.TodoUpdatedEvent;
import com.sjd.service1.event.TodoUppercasedEvent;
import io.eventuate.Event;
import io.eventuate.EventUtil;
import io.eventuate.ReflectiveMutableCommandProcessingAggregate;
import lombok.Data;

@Data
public class TodoAggregate extends ReflectiveMutableCommandProcessingAggregate<TodoAggregate, TodoCommand> {

    private TodoInfo todoInfo;

    private boolean deleted;

    public List<Event> process(CreateTodoCommand cmd) {

        if (this.deleted) {
            return Collections.emptyList();
        }

        return EventUtil.events(new TodoCreatedEvent(cmd.getTodoInfo()));
    }

    public List<Event> process(UpdateTodoCommand cmd) {

        if (this.deleted) {
            return Collections.emptyList();
        }

        return EventUtil.events(new TodoUpdatedEvent(cmd.getTodo()));

    }

    public List<Event> process(UppercaseTodoCommand cmd) {

        if (this.deleted) {
            return Collections.emptyList();
        }

        return EventUtil.events(new TodoUppercasedEvent(cmd.getTodoInfo()));

    }

    /*******************************************************************************************/

    public void apply(TodoCreatedEvent event) {

        this.todoInfo = event.getTodoInfo();

    }

    public void apply(TodoUpdatedEvent event) {

        TodoInfo update = event.getTodoInfo();

        if (update.getTitle() != null)
            this.todoInfo.setTitle(update.getTitle());

        if (update.getOrder() > 0)
            this.todoInfo.setOrder(update.getOrder());

    }

    public void apply(TodoUppercasedEvent event) {

        TodoInfo update = event.getTodoInfo();

        if (update.getTitle() != null)
            this.todoInfo.setTitle(update.getTitle().toUpperCase());

    }
}


