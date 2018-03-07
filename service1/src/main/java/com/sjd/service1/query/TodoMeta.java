package com.sjd.service1.query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * User: stevedavis
 * Date: 07/03/2018
 * Time: 19:36
 * Description:
 */
@Data
@Entity
@NoArgsConstructor
public class TodoMeta {

    @Id
    @GeneratedValue(generator = "todo_meta_seq", strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "todo_meta_seq", sequenceName = "TODO_META_SEQ", allocationSize = 1)
    private Integer id;

    private String name;

    private String value;

    public TodoMeta(String name, String value) {

        this.name = name;
        this.value = value;

    }
}
