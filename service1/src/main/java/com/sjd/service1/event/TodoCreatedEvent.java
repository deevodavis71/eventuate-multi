package com.sjd.service1.event;

import com.sjd.service1.backend.domain.TodoInfo;
import lombok.Data;

@Data
public class TodoCreatedEvent implements TodoEvent {

    TodoInfo todo;

    private TodoCreatedEvent() {
    }

    public TodoCreatedEvent(TodoInfo todo) {
        this.todo = todo;
    }

}