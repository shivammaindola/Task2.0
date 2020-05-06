package com.example.task2;

public class Model {
    String hint;
    public String name;
    String regex;
    private String edit;

    String getEdit() {
        return edit;
    }

    void setEdit(String edit) {
        this.edit = edit;
    }


    Model(String hint, String regex, String name) {
        this.hint = hint;
        this.name = name;
        this.regex = regex;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String getRegex() {
        return regex;
    }

    void setRegex(String regex) {
        this.regex = regex;
    }
}
