package com.example.iotassign.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iotassign.R
import com.example.iotassign.data.MyDataItem
import com.example.iotassign.databinding.RowItemsBinding

class MyAdapter(val context: Context, val userList: List<MyDataItem>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding   = RowItemsBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(userList[position]) {
                binding.name.text = name
                binding.description.text = description
                binding.price.text = "$" + price
                binding.brand.text = brand
//                binding.imageLink
                Glide.with(holder.itemView.context).load(userList[position].image_link).into(binding.imageLink)
            }
        }
//        val user = userList[position]
//        holder.name.text = user.name
//        holder.description.text = user.description
//        holder.price.text = "$" + user.price
//        Glide.with(context).load(user.image_link).into(holder.image_link)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

//    inner class ViewHolder(itemView: @NonNull RowItemsBinding) :RecyclerView.ViewHolder(itemView) {
//        var image_link: ImageView
//        var price: TextView
//        var name:TextView
//        var description:TextView
//        init {
//            image_link = itemView.findViewById(R.id.image_link);
//            name = itemView.findViewById(R.id.name);
//            description = itemView.findViewById(R.id.description);
//            price = itemView.findViewById(R.id.price)
//        }
//    }
    inner class ViewHolder(val binding: RowItemsBinding)
        :RecyclerView.ViewHolder(binding.root)

}