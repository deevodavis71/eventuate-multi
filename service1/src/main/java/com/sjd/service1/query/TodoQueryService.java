package com.sjd.service1.query;

import org.springframework.stereotype.Service;

/**
 * User: stevedavis
 * Date: 06/03/2018
 * Time: 19:29
 * Description:
 */
@Service
public class TodoQueryService {

    private TodoRepository repository;

    public TodoQueryService(TodoRepository repository) {
        this.repository = repository;
    }

    public Todo save(Todo todo) {
        return repository.save(todo);
    }
}
