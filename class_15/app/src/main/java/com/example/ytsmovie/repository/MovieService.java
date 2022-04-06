package com.example.ytsmovie.repository;

import com.example.ytsmovie.models.YtsData;
import com.example.ytsmovie.utils.Define;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

// https://yts.mx/api/v2/list_movies.json?limit=1&page=2&sort_by=rating
public interface MovieService {

    // public static final
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Define.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    // dto 만들기기
   @GET("list_movies.json")
    Call<YtsData> repoContributors(@Query("sort_by") String sortBy,
                                   @Query("page") int page,
                                   @Query("limit") int limit);

}
