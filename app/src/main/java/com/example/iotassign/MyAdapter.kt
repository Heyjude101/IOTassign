package com.example.iotassign

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(val context: Context, val userList: List<MyDataItem>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {
        var image_link: ImageView
        var price: TextView
        var name:TextView
        var description:TextView
        init {
            image_link = itemView.findViewById(R.id.image_link);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_items , parent , false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = userList[position]
        holder.name.text = user.name
        holder.description.text = user.description
        holder.price.text = "$" + user.price
        Glide.with(context).load(user.image_link).into(holder.image_link)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

}