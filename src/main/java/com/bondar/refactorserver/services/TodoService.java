package com.bondar.refactorserver.services;

import com.bondar.refactorserver.data.TodoItem;

import java.util.ArrayList;
import java.util.List;

public interface TodoService {
    TodoItem addTodoItem(TodoItem item);
    List<TodoItem> getLastTodos();
    List<TodoItem> searchTodos(String ... tags);
}