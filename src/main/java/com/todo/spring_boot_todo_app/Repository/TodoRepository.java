package com.todo.spring_boot_todo_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todo.spring_boot_todo_app.Model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    
}