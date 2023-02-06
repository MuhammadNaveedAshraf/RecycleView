package com.example.recycleview

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.lang.Math.abs

class MyAdapter(private val context: Context,val songs: MutableList<Song>): Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view,parent, false)
        return MyViewHolder(view)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.translationX += holder.itemView.width.toFloat()
        holder.txtTitle.text = songs[position].title
        holder.txtDescp.text = songs[position].description
//        holder.itemView.animate().translationX(0f).setDuration(1000).start()
//            holder.itemView.alpha = 0f
        holder.itemView.animate().alpha(1f).setDuration(500).start()
    }
    override fun getItemCount(): Int {
        return songs.size
    }

    class MyViewHolder(itemView: View) : ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.card_view)
        var txtTitle = itemView.findViewById<TextView>(R.id.txtTitle)
        var txtDescp = itemView.findViewById<TextView>(R.id.txtDescription)
    }
}
