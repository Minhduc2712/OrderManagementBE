package com.project.Restaurant_Managementv2.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name="ProductId")
    private Product product;

    @ManyToOne
    @JoinColumn(name="ParentCommentId")
    private Comment parentComment;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<Comment> replies = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name="UserId")
    private User user;

    public Comment(Long id, String content, Product product, Comment parentComment, List<Comment> replies, User user) {
        this.id = id;
        this.content = content;
        this.product = product;
        this.parentComment = parentComment;
        this.replies = replies;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public List<Comment> getReplies() {
        return replies;
    }

    public void setReplies(List<Comment> replies) {
        this.replies = replies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
