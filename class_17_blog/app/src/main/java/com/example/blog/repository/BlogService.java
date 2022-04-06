package com.example.blog.repository;

import com.example.blog.models.request.ReqJoin;
import com.example.blog.models.request.ReqLogin;
import com.example.blog.models.response.ResJoin;
import com.example.blog.models.response.ResLogin;
import com.example.blog.models.response.ResPost;
import com.example.blog.models.response.ResUserDto;
import com.example.blog.utils.Define;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BlogService {

    @GET("/init/user")
    Call<ResUserDto> initUser();

    @GET("init/post")
    Call<ResPost> initPost();

    @POST("join")
    Call<ResJoin> join(@Body ReqJoin reqJoin);

    @POST("login")
    Call<ResLogin> login(@Body ReqLogin reqLogin);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Define.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
