package com.emptycoder.apiassignment.api

import com.emptycoder.apiassignment.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiCLient {
    val BASE_URL = "http://newsapi.org/v2/"
    val apiInterface : ApiInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiInterface = retrofit.create(ApiInterface::class.java)
    }

    fun getNewsWithCategory(category: String):Call<News>{
        return apiInterface.getNewsWithCategory(
            "us",
            category,
            "a3335a72fd254ce7bbaeb2d818aad48b"
        )
    }

    fun getAllNews(query: String):Call<News>{
        return apiInterface.getAllNews(
            query,
            "a3335a72fd254ce7bbaeb2d818aad48b"
        )
    }
}