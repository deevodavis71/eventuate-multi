package com.sjd.service1.backend.domain.snapshot;

import com.sjd.service1.backend.domain.TodoInfo;
import io.eventuate.Snapshot;
import lombok.Data;

/**
 * User: stevedavis
 * Date: 07/03/2018
 * Time: 17:18
 * Description:
 */
@Data
public class TodoSnapshot implements Snapshot {

    private TodoInfo info;

    public TodoSnapshot(TodoInfo todoInfo) {

        this.info = todoInfo;

    }

}
