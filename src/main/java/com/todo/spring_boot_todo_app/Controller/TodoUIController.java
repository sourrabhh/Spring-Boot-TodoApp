package com.todo.spring_boot_todo_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.todo.spring_boot_todo_app.Model.Todo;
import com.todo.spring_boot_todo_app.Service.TodoService;

@Controller
public class TodoUIController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "index";
    }

    @PostMapping("/create")
    public String createTodo(@ModelAttribute Todo todo) {
        todoService.createTodo(todo);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return "redirect:/";
    }
}