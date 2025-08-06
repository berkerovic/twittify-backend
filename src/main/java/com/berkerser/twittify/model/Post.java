package com.berkerser.twittify.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="posts")
public class Post {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200) //Twitter gibi 200 karakter sınırı
    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false) //foreign key
    private User user;

    public Post(){}


    public Post(String content, User user){
        this.content = content;
        this.user = user;
        this.createdAt = LocalDateTime.now();
    }


    public Long getId() {return id;}
    public void setId(Long id){this.id = id;}

    public String getContent(){return content;}
    public void setContent(String content) {this.content = content;}

    public LocalDateTime getCreatedAd() {return createdAt;}
    public void getCreatedAd(LocalDateTime createdAt){this.createdAt = createdAt;}

    public User getUser() {return user;}
    public void setUser(User user) {this.user = user;}

}
