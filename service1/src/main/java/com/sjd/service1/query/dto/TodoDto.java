package com.sjd.service1.query.dto;

import com.sjd.common.backend.domain.TodoInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: stevedavis
 * Date: 07/03/2018
 * Time: 18:24
 * Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {

    private String id;

    private String title;

    private boolean completed;

    private int order;

    public TodoDto(String id, TodoInfo info) {

        this.id = id;

        this.title = info.getTitle();
        this.order = info.getOrder();
        this.completed = info.isCompleted();

    }

}
