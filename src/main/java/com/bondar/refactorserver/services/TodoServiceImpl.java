package com.bondar.refactorserver.services;

import com.bondar.refactorserver.data.TodoBank;
import com.bondar.refactorserver.data.TodoItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    TodoBank todoBank;

    public TodoServiceImpl() {
        this.todoBank = TodoBank.getInstance();
    }

    @Override
    public TodoItem addTodoItem(TodoItem item) {
        this.todoBank.addTodo(item);
        return item;
    }

    @Override
    public List<TodoItem> getLastTodos() {
        return this.todoBank.getLastTodos();
    }

    @Override
    public List<TodoItem> searchTodos(String... tags) {
        return this.todoBank.getTodosByTags(tags);
    }
}
