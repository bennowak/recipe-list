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
    @Column(name="id")
    private Long id;

    private String username;
    private String hash;
    private String token;
    @Column(name="token_expiration")
    private Date token_expiration;

    public SiteUser(Long id, String username, String hash, String token, Date token_expiration) {
        this.id = id;
        this.username = username;
        this.hash = hash;
        this.token = token;
        this.token_expiration = token_expiration;
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

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getTokenExpiration() {
        return token_expiration;
    }

    public void setTokenExpiration(Date expiration) {
        this.token_expiration = expiration;
    }

    @Override
    public String toString() {
        return String.format("SiteUser ( id=%s, username=%s, hash=%s, token=%s, expiration=%s)",
                this.id,
                this.username,
                this.hash,
                this.token,
                this.token_expiration);
    }
}
