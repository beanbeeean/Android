package com.example.myhttpconnection.models.request;


// title : 'foo'
//          body : 'bar
//          userId : 1
public class ReqPost {
    private String title;
    private String body;
    private int userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
