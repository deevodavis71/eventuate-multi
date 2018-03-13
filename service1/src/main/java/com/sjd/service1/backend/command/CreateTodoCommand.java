package com.sjd.service1.backend.command;

import com.sjd.common.backend.domain.TodoInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateTodoCommand implements TodoCommand {

    private TodoInfo todoInfo;

}
