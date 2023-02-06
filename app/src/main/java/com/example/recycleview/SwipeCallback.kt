package com.example.recycleview

import android.annotation.SuppressLint
import android.telephony.ims.ImsMmTelManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import java.lang.Math.min

class SwipeCallback(private val adapter:PostAdapter): ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        return makeMovementFlags(0,ItemTouchHelper.LEFT)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        if(direction == ItemTouchHelper.LEFT) {
            val position = viewHolder.adapterPosition
            adapter.posts.removeAt(position)
            adapter.notifyItemRemoved(position)
//            adapter.notifyDataSetChanged()
//            adapter.notifyItemRangeChanged(position,adapter.songs.size)
//            adapter.notifyItemRangeRemoved(position,1)
        }
        else{

        }
    }

}