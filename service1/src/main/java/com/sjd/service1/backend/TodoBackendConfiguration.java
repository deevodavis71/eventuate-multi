package com.sjd.service1.backend;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sjd.service1.backend.command.TodoCommand;
import com.sjd.service1.backend.domain.TodoAggregate;
import com.sjd.service1.query.TodoQueryService;
import com.sjd.service1.query.TodoQueryWorkflow;
import io.eventuate.AggregateRepository;
import io.eventuate.EventuateAggregateStore;
import io.eventuate.javaclient.spring.EnableEventHandlers;

/**
 * User: stevedavis
 * Date: 06/03/2018
 * Time: 19:24
 * Description:
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.sjd"})
@EntityScan("com.sjd")
@EnableJpaRepositories("com.sjd")
@EnableEventHandlers
public class TodoBackendConfiguration {

    @Bean
    public AggregateRepository<TodoAggregate, TodoCommand> aggregateRepository(EventuateAggregateStore eventStore) {
        return new AggregateRepository<>(TodoAggregate.class, eventStore);
    }

    @Bean
    public TodoQueryWorkflow todoQueryWorkflow(TodoQueryService queryService) {
        return new TodoQueryWorkflow(queryService);
    }
}
