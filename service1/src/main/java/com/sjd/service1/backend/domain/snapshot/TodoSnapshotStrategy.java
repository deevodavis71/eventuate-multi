package com.sjd.service1.backend.domain.snapshot;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.sjd.service1.backend.command.CreateTodoCommand;
import com.sjd.service1.backend.domain.TodoAggregate;
import io.eventuate.Aggregate;
import io.eventuate.Aggregates;
import io.eventuate.Event;
import io.eventuate.EventWithMetadata;
import io.eventuate.Int128;
import io.eventuate.MissingApplyEventMethodStrategy;
import io.eventuate.Snapshot;
import io.eventuate.SnapshotStrategy;

/**
 * User: stevedavis
 * Date: 07/03/2018
 * Time: 17:15
 * Description:
 */
@Component
public class TodoSnapshotStrategy implements SnapshotStrategy {

    @Override
    public Class<?> getAggregateClass() {
        return TodoAggregate.class;
    }

    @Override
    public Optional<Snapshot> possiblySnapshot(Aggregate aggregate, Optional<Int128> snapshotVersion, List<EventWithMetadata> oldEvents, List<Event> newEvents) {

        TodoAggregate todo = (TodoAggregate) aggregate;
        return Optional.of(new TodoSnapshot(todo.getTodoInfo()));

    }

    @Override
    public Aggregate recreateAggregate(Class<?> aClass, Snapshot snapshot, MissingApplyEventMethodStrategy missingApplyEventMethodStrategy) {

        TodoSnapshot todoSnapshot = (TodoSnapshot) snapshot;
        TodoAggregate todo = new TodoAggregate();
        List<Event> events = todo.process(new CreateTodoCommand(todoSnapshot.getInfo()));
        Aggregates.applyEventsToMutableAggregate(todo, events, missingApplyEventMethodStrategy);
        return todo;

    }

}
