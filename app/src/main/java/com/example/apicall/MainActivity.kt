package com.example.apicall

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.Model.MyData
import com.example.apicall.MyAdapter.MyAdapter
import com.example.apicall.MyInterface.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        // find id

        recyclerView=findViewById(R.id.recyclerview)






        // way of calling api  // create retrofit builder


        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        //  getProductData jo apnne interface mai banaya  hai

        val retrofitData= retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
            // if ap[i call sucess , then use the api and show your app data

                var responseBody =response.body()
                val productList = responseBody?.products!!


                myAdapter= MyAdapter(this@MainActivity, productList)
                recyclerView.adapter= myAdapter
                recyclerView.layoutManager= LinearLayoutManager(this@MainActivity)




            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
            // if api call Fail

                Log.d("this@MainActivity", "onFailure: "+ t.message)




            }
        })

    }
}

