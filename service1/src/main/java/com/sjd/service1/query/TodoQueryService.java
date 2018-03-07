package com.sjd.service1.query;

import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import io.eventuate.CompletableFutureUtil;

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

    public CompletableFuture<Todo> findById(String todoId) {

        Todo res = repository.findOne(todoId);
        if (res != null) {
            return CompletableFuture.completedFuture(res);
        }

        return CompletableFutureUtil.failedFuture(new NoSuchElementException("No todoInfo with given id found"));

    }
}
