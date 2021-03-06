package com.sjd.service1.query;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sjd.common.backend.domain.TodoInfo;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Todo {

    @Id
    private String id;

    //@Column
    private String title;

    //@Column
    private Boolean completed;

    @Column(name = "order_id")
    private Integer order;

    //@Column
    private java.util.Date updatedAt;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TodoMeta> metadata;

    public Todo(TodoInfo todoInfo) {
        this.title = todoInfo.getTitle();
        this.completed = todoInfo.isCompleted();
        this.order = todoInfo.getOrder();
    }

    public Todo(String title) {
        this.title = title;
    }

    public Todo(String id, String title, Boolean completed, Integer order) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.order = order;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return nonNull(completed, false);
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getOrder() {
        return nonNull(order, 0);
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public java.util.Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(java.util.Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Todo merge(Todo newTodo) {
        return new Todo(id,
                nonNull(newTodo.title, title),
                nonNull(newTodo.completed, completed),
                nonNull(newTodo.order, order));
    }

    public void addMetadata(String name, String value) {

        if (metadata == null)
            metadata = new ArrayList<>();

        metadata.removeIf(f -> f.getName().equalsIgnoreCase(name));
        metadata.add(new TodoMeta(name, value));

    }

    private <T> T nonNull(T value, T defaultValue) {
        return value == null ? defaultValue : value;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", order=" + order +
                '}';
    }
}
