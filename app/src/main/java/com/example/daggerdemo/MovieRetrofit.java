package com.example.daggerdemo;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRetrofit {
    private static MovieRetrofit sMovieRetrofit;
    private final GitHubService mApi;
    public static MovieRetrofit getInstance(){
        if(sMovieRetrofit==null){
            synchronized (MovieRetrofit.class){
                if(sMovieRetrofit == null){
                    sMovieRetrofit = new MovieRetrofit();
                }
            }
        }
        return sMovieRetrofit;
    }

    public GitHubService getApi() {
        return mApi;
    }

    private MovieRetrofit(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApi = retrofit.create(GitHubService.class);
    }
}
