package com.kim.domain;

public class Excel {
    private String position;
    private String value;

    public Excel(String position, String value) {
        this.position = position;
        this.value = value;
    }

    public Excel() {}

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
