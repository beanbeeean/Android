package com.example.blog.models.response;

public class Data {
    public int id;
    public String username;
    public String email;
    public String created;
    public String updated;

    public String password;

    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
