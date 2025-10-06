package com.hichinfo.todos.repository;

import com.hichinfo.todos.entity.Todo;
import com.hichinfo.todos.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findByOwner(User owner);
}
