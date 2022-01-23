package com.bondar.refactorserver.data;

import lombok.Data;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;

@Data
public class TodoItem {

    public TodoItem(String name, String description, String deadline, ArrayList<String> tags) {
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.tags = tags;
    }

    public TodoItem() {
        tags = new ArrayList<>();
    }

    private String name;
    private String description;
    private String deadline;
    private ArrayList<String> tags;

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", getName());
        jsonObject.put("description", getDescription());
        jsonObject.put("deadline", getDeadline());
        jsonObject.put("tags", getTags());
        return jsonObject;
    }

}
