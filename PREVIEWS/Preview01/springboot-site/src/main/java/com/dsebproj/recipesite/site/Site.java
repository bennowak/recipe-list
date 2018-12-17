package com.dsebproj.recipesite.site;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String hash;
    private String token;
    private Date expiration;

    public Site(Long id, String username, String hash, String token, Date expiration) {
        this.id = id;
        this.username = username;
        this.hash = hash;
        this.token = token;
        this.expiration = expiration;
    }

    public Site(){

    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
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

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    @Override
    public String toString() {
        return String.format("Site ( id=%s, username=%s, hash=%s, token=%s, expiration=%s)",
                this.id,
                this.username,
                this.hash,
                this.token,
                this.expiration);
    }
}
