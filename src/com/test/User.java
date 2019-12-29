package com.test;

public class User {
    private String id;
    private String password;
    private Integer identity;

    User(String id, String password, Integer identity){
        this.id = id;
        this.password = password;
        this.identity = identity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }
}
