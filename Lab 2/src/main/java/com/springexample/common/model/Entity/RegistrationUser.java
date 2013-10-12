package com.springexample.common.model.Entity;

import com.springexample.common.constraits.FieldMatch;

import javax.persistence.Column;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "repeatPassword", message = "The password fields must match"),
})

public class RegistrationUser extends User {

    @NotNull
    @Size(min=8, max=25)
    @Column(nullable = false)
    private transient String password;

    @NotNull
    @Size(min=8, max=25)
    @Transient
    private transient String repeatPassword;

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
