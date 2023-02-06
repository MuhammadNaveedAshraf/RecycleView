package com.example.recycleview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(val posts: MutableList<Post>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view,parent, false)
        return MyAdapter.MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        holder.itemView.translationX += holder.itemView.width.toFloat()
        holder.txtTitle.text = posts[position].title
        holder.txtDescp.text = posts[position].body
//        holder.itemView.animate().translationX(0f).setDuration(1000).start()
//            holder.itemView.alpha = 0f
        holder.itemView.animate().alpha(1f).setDuration(500).start()
    }

    override fun getItemCount(): Int {
        return posts.size
    }
    @SuppressLint("NotifyDataSetChanged")
    fun updateData(newPosts: List<Post>){
        posts.clear()
        posts.addAll(newPosts)
        notifyDataSetChanged()
    }

}