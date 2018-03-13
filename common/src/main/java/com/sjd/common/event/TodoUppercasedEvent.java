package com.sjd.common.event;

import com.sjd.common.backend.domain.TodoInfo;
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
public class TodoUppercasedEvent implements TodoEvent {

    TodoInfo todoInfo;

    private TodoUppercasedEvent() {
    }
}
