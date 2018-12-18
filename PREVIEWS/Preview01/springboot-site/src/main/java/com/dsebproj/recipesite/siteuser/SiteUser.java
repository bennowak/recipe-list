package com.dsebproj.recipesite.siteuser;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name="id")
    private Long id;

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String hash;
    private boolean agree;
//    private String token;
//    //@Column(name="token_expiration")
//    private Date token_expiration;

    public SiteUser(Long id, String username, String firstName, String lastName, String email, String hash, boolean agree) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.hash = hash;
        this.agree = agree;
//        this.token = token;
//        this.token_expiration = token_expiration;
    }

    public SiteUser(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    @Override
    public String toString() {
        return String.format("SiteUser ( id=%s, username=%s, firstName=%s, lastName=%s, email=%s, hash=%s)",
                this.id,
                this.username,
                this.firstName,
                this.lastName,
                this.email,
                this.hash);
    }
}
