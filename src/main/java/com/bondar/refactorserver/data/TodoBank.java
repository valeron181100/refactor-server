package com.bondar.refactorserver.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class TodoBank {

    private static TodoBank instance;
    private ArrayList<TodoItem> todos;


    private TodoBank() {
        todos = new ArrayList<>();
        todos.add(new TodoItem("Test task", "test desc", "11.01.2022", new ArrayList<>(Arrays.asList("movie", "sport", "art"))));
        todos.add(new TodoItem("Test task", "test desc", "11.01.2022", new ArrayList<>(Arrays.asList("sport", "art"))));
        todos.add(new TodoItem("Test task", "test desc", "11.01.2022", new ArrayList<>(Arrays.asList("movie", "art"))));
    }

    public static TodoBank getInstance() {
        if (instance == null)
            instance = new TodoBank();
        return instance;
    }

    public List<TodoItem> getTodos() {
        return todos;
    }

    public void addTodo(TodoItem todo) {
        getTodos().add(todo);
    }

    public List<TodoItem> getTodosByTags(String... tags) {
        List<TodoItem> resultArr = new ArrayList<>();
        getTodos().forEach(todo -> {
            for (String todoTag : todo.getTags())
                if (Arrays.asList(tags).contains(todoTag))
                    resultArr.add(todo);
        });
        return resultArr;
    }

    public List<TodoItem> getLastTodos() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        ArrayList<TodoItem> cloned = new ArrayList<>(getTodos());
        cloned.sort((a, b) -> {
            try {
                return formatter.parse(a.getDeadline()).compareTo(formatter.parse(b.getDeadline()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            finally {
                return -1;
            }
        });
        return cloned;
    }
}
