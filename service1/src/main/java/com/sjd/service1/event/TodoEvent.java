package com.sjd.service1.event;


import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.sjd.service1.backend.domain.TodoAggregate")
public interface TodoEvent extends Event {
}
