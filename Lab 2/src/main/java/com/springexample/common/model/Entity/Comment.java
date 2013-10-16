package com.springexample.common.model.Entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment extends BaseEntity<Long> {

    @Column(nullable = false)
    @NotBlank
    private String title;

    @Column(nullable = false)
    @NotBlank
    private String text;

    @ManyToOne()
    private User user;

    @ManyToOne
    private Post post;

    //Constructors
    public Comment() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
