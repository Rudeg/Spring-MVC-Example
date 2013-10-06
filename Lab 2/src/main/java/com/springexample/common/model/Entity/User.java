package com.springexample.common.model.Entity;

import com.springexample.common.constraits.FieldMatch;
import com.springexample.common.model.SexEnum;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@FieldMatch.List({
        @FieldMatch(first = "password", second = "repeatPassword", message = "The password fields must match"),
})

@Entity
@Table(name="users")
public class User extends BaseEntity<Long> {

    //textboxes
    @Column(nullable = false)
    @NotBlank
    private String username;

    @Column(nullable = false)
    @NotBlank
    private String firstname;

    @Column(nullable = false)
    @NotBlank
    private String lastname;

    @Column(nullable = false)
    @NotNull
    @Size(min=8, max=25)
    private String password;

    @NotNull
    @Size(min=8, max=25)
    private String repeatPassword;

    @Column(name = "sexValue", nullable = false)
    @Enumerated(EnumType.STRING)
    //radio button
    @NotNull
    private SexEnum sex;

    //checkboxes
    private String [] progLang;

    @Column(nullable = false)
    private Boolean receiveNewsLetter;

    @Column(nullable = false)
    @NotBlank
    private String country;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "ex_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> userRoles;


    // getters and setters...
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

    public Set<Role> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<Role> userRoles) {
        this.userRoles = userRoles;
    }
}
