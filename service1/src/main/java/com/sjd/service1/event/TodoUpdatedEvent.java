package com.sjd.service1.event;

import com.sjd.service1.backend.domain.TodoInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * User: stevedavis
 * Date: 07/03/2018
 * Time: 17:45
 * Description:
 */
@Data
@AllArgsConstructor
public class TodoUpdatedEvent implements TodoEvent {

    TodoInfo todoInfo;

    private TodoUpdatedEvent() {
    }
}
