package com.example.apicall.MyAdapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.Model.Product
import com.example.apicall.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso


class MyAdapter(val context: Activity, val productArrayList: List<Product>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productArrayList[position]
        holder.title.text = currentItem.title

        // add picshow for show image your app


        Picasso.get().load(currentItem.thumbnail).into(holder.image);



    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }


    //  MyViewholder class


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var title: TextView
        var image: ShapeableImageView


        init {
            title = itemView.findViewById(R.id.productTitle)
            image = itemView.findViewById(R.id.hImage)
        }


    }


}