package com.sjd.service1.web;

import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjd.service1.backend.domain.TodoInfo;
import com.sjd.service1.backend.domain.TodoService;
import com.sjd.service1.query.dto.TodoDto;

/**
 * User: stevedavis
 * Date: 06/03/2018
 * Time: 19:16
 * Description:
 */
@RestController
@RequestMapping(value = "/todos")
public class TodoCommandController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public CompletableFuture<String> saveTodo(@RequestBody TodoInfo todo, HttpServletRequest request) {

        return todoService.save(todo).thenApply(e -> e.getEntityId());

    }

    @PutMapping(value = "/{todoInfo-id}", headers = {"Content-type=application/json"})
    public CompletableFuture<TodoDto> updateTodo(@PathVariable("todoInfo-id") String id, @RequestBody TodoInfo newTodo, HttpServletRequest request) {

        return todoService.update(id, newTodo).thenApply(e -> new TodoDto(e.getEntityId(), e.getAggregate().getTodoInfo()));

    }
}
