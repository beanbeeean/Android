package com.example.blog.models.response;

import com.example.blog.models.common.Response;

public class ResPost extends Response {

    public int id;
    public String title;
    public String content;
    public ResUserDto user;
    public String created;
    public String updated;

}
