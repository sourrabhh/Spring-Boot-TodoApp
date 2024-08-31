package com.todo.spring_boot_todo_app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.spring_boot_todo_app.Model.Todo;
import com.todo.spring_boot_todo_app.Repository.TodoRepository;

import java.util.List;
import java.util.Optional;
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todoDetails) {
        return todoRepository.findById(id).map(todo -> {
            todo.setTitle(todoDetails.getTitle());
            todo.setDescription(todoDetails.getDescription());
            todo.setCompleted(todoDetails.isCompleted());
            return todoRepository.save(todo);
        }).orElseGet(() -> {
            todoDetails.setId(id);
            return todoRepository.save(todoDetails);
        });
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }
}