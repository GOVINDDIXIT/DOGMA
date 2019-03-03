package com.example.govind.techie;

import com.example.govind.techie.Models.PostList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class BloggerAPI {
    private static final String key = "AIzaSyDOd75Y820zCVYz8dBYT4N7VmS2vA0ibM8";
    private static final String url = "https://www.googleapis.com/blogger/v3/blogs/7760882925893837625/posts/";

    public static PostService postService =null;
    public static PostService getService()
    {
        if(postService==null)
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

                    postService=retrofit.create(PostService.class);
        }
        return postService;
    }


    public interface PostService {
        @GET("?key=" + key)
        Call<PostList> getPostList();
    }


}
