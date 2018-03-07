package com.sjd.service1.event;

import com.sjd.service1.backend.domain.TodoInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoCreatedEvent implements TodoEvent {

    TodoInfo todoInfo;

    private TodoCreatedEvent() {
    }

}