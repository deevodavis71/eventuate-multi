package com.sjd.service1.backend.domain;

import lombok.Data;

/**
 * User: stevedavis
 * Date: 06/03/2018
 * Time: 19:12
 * Description:
 */
@Data
public class TodoInfo {

    private String title;
    private boolean completed;
    private int order;

}