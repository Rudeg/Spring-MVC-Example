package com.springexample.common.model;

public enum SexEnum {
    M("MEN"), W("WOMEN");

    private String sex;

    private SexEnum(String s) {
        sex = s;
    }

    public String getSex() {
        return sex;
    }
}
