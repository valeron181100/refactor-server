package com.bondar.refactorserver.controllers;

import com.bondar.refactorserver.data.TodoItem;
import com.bondar.refactorserver.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {


    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public TodoItem addTodo(@RequestBody TodoItem item) {
        return todoService.addTodoItem(item);
    }

    @GetMapping
    public List<TodoItem> lastTodos() {
        return todoService.getLastTodos();
    }

    @GetMapping("/by_tag")
    public List<TodoItem> searchTodosByTags(@RequestParam("tags") String[] tags) {
        return todoService.searchTodos(tags);
    }

}
