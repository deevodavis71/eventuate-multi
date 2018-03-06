package com.sjd.service1.web;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjd.service1.backend.domain.TodoAggregate;
import com.sjd.service1.backend.domain.TodoInfo;
import com.sjd.service1.backend.domain.TodoService;
import io.eventuate.EntityWithIdAndVersion;

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

    @RequestMapping(method = POST)
    public CompletableFuture<String> saveTodo(@RequestBody TodoInfo todo, HttpServletRequest request) {
        return todoService.save(todo).thenApply(e -> e.getEntityId());
    }
}
