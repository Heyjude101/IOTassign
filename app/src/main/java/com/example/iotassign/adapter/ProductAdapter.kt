package com.example.iotassign.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.iotassign.R
import com.example.iotassign.room.ProductTable

class ProductAdapter : ListAdapter<ProductTable, ProductAdapter.ProductViewHolder>(DiffUtil()) {

    class DiffUtil: androidx.recyclerview.widget.DiffUtil.ItemCallback<ProductTable>() {
        override fun areItemsTheSame(oldItem: ProductTable, newItem: ProductTable): Boolean {
            return oldItem.id ==  newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductTable, newItem: ProductTable): Boolean {
            return oldItem == newItem
        }

    }
    class ProductViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.name)
        val brand: TextView = view.findViewById(R.id.brand)
        val desc: TextView = view.findViewById(R.id.description)
        val price: TextView = view.findViewById(R.id.price)
        val imageLink: ImageView = view.findViewById(R.id.image_link)

        fun bind(productTable: ProductTable) {
            name.text = productTable.name
            brand.text = productTable.brand
            desc.text = productTable.description
            price.text = productTable.price
            Glide.with(name.context).load(productTable.image_link).into(imageLink)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_items ,parent , false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}






























//class ProductAdapter(val context: Context, val userList: List<ProductTable>):
//    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val binding   = RowItemsBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
//        return ViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        with(holder){
//            with(userList[position]) {
//                binding.name.text = name
//                binding.description.text = description
//                binding.price.text = "$" + price
//                binding.brand.text = brand
////                binding.imageLink
//                Glide.with(holder.itemView.context).load(userList[position].image_link).into(binding.imageLink)
//            }
//        }
////        val user = userList[position]
////        holder.name.text = user.name
////        holder.description.text = user.description
////        holder.price.text = "$" + user.price
////        Glide.with(context).load(user.image_link).into(holder.image_link)
//    }
//
//    override fun getItemCount(): Int {
//        return userList.size
//    }
//
////    inner class ViewHolder(itemView: @NonNull RowItemsBinding) :RecyclerView.ViewHolder(itemView) {
////        var image_link: ImageView
////        var price: TextView
////        var name:TextView
////        var description:TextView
////        init {
////            image_link = itemView.findViewById(R.id.image_link);
////            name = itemView.findViewById(R.id.name);
////            description = itemView.findViewById(R.id.description);
////            price = itemView.findViewById(R.id.price)
////        }
////    }
//    inner class ViewHolder(val binding: RowItemsBinding)
//        :RecyclerView.ViewHolder(binding.root)
//
//}