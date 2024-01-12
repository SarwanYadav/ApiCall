package com.example.apicall.MyInterface

import com.example.apicall.Model.MyData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")

    fun getProductData(): Call<MyData>
}