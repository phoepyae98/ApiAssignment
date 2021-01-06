package com.emptycoder.apiassignment.api


import com.emptycoder.apiassignment.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("top-headlines")
    fun getNewsWithCategory(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("key") apiKey: String
    ):Call<News>

    @GET("everything")
    fun getAllNews(
        @Query("q") query: String,
        @Query("key") apiKey: String
    ):Call<News>

}