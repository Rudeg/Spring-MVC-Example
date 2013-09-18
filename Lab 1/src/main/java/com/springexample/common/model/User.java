package com.springexample.common.model;

public class User {
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String repeatPassword;
    private SexEnum sex;
    private String [] progLang;
    private String country;
    private Boolean receiveNewsLetter;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public String[] getProgLang() {
        return progLang;
    }

    public void setProgLang(String[] progLang) {
        this.progLang = progLang;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getReceiveNewsLetter() {
        return receiveNewsLetter;
    }

    public void setReceiveNewsLetter(Boolean receiveNewsLetter) {
        this.receiveNewsLetter = receiveNewsLetter;
    }
}
