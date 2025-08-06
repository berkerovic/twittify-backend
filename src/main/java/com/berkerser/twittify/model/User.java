package com.berkerser.twittify.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")  //DB'deki tablo adını belirledik.   
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //Primary Key

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    //Boş constructor JPA için zorunlu.
    public User(){}

    //Dolu constructor
    public User(String username, String email){
        this.username = username;
        this.email = email;
    }

    //Getter & Setter
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
