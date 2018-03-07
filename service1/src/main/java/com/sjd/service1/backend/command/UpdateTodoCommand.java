package com.sjd.service1.backend.command;

import com.sjd.service1.backend.domain.TodoInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * User: stevedavis
 * Date: 07/03/2018
 * Time: 17:44
 * Description:
 */
@Data
@AllArgsConstructor
public class UpdateTodoCommand implements TodoCommand {

    private String id;

    private TodoInfo todo;

}
