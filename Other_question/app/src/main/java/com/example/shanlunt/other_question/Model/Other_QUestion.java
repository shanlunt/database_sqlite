package com.example.shanlunt.other_question.Model;

/**
 * Created by shanlunt on 3/21/17.
 */

public class Other_QUestion {

    private long id;
    private String value;

    public Other_QUestion() {
        super();
    }

    public Other_QUestion(String value) {
        super();
        this.value = value;
    }

    public Other_QUestion(long id, String value) {
        super();
        this.id = id;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
