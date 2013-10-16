package com.springexample.common.model.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "user_roles")
public class Role extends BaseEntity<Long> {

    private String authority;

    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE}, mappedBy="userRoles")
    private Set<User> users;

    //Constructors
    public Role() {
    }

    public Role(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
