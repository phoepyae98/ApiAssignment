package com.emptycoder.apiassignment.ui.all

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.emptycoder.apiassignment.api.ApiCLient
import com.emptycoder.apiassignment.model.News
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AllViewModel : ViewModel() {

    var news: MutableLiveData<News> = MutableLiveData()
    var apiClient = ApiCLient()
    var apiCall = apiClient.getAllNews("bitcoin")

    fun setNews(): LiveData<News> = news

    fun getNews(){
        apiCall.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                news.value = response.body()
                Log.d("Data>>",response.body()!!.articles.toString())
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
               Log.d("Response>",t.toString())
            }
        })
    }
}