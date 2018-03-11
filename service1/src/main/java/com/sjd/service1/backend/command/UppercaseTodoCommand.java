package com.sjd.service1.backend.command;

import com.sjd.service1.backend.domain.TodoInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * User: stevedavis
 * Date: 11/03/2018
 * Time: 08:39
 * Description:
 */
@Data
@AllArgsConstructor
public class UppercaseTodoCommand implements TodoCommand {

    private String id;

    private TodoInfo todoInfo;

}
