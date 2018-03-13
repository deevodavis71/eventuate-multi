package com.sjd.common.event;

import com.sjd.common.backend.domain.TodoInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TodoCreatedEvent implements TodoEvent {

    TodoInfo todoInfo;

    private TodoCreatedEvent() {
    }

}