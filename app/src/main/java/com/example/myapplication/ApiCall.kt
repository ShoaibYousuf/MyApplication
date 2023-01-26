package com.example.myapplication

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiCall {
    @GET("/quotes")
    fun fetchData(): Call<DataClass>
}
