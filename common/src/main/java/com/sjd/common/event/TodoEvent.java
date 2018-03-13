package com.sjd.common.event;


import io.eventuate.Event;
import io.eventuate.EventEntity;

@EventEntity(entity = "com.sjd.service1.backend.domain.TodoAggregate")
public interface TodoEvent extends Event {
}
