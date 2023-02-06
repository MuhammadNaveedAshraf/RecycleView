package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers


class MainActivity : AppCompatActivity() {
    private lateinit var postAdapter:PostAdapter
    private lateinit var apiService:APIService
    private lateinit var recyclerView:RecyclerView
    private var initCallback: (() -> Unit)? = null
    private lateinit var postList: MutableList<Post>
//    private fun setupAdapter(posts:List<Post>, recyclerView: RecyclerView){
//        recyclerView.adapter = PostAdapter(posts as MutableList<Post>)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        ItemTouchHelper(SwipeCallback(postAdapter)).attachToRecyclerView(recyclerView)
//    }

    private fun setupPostAdapter(){
        apiService.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map{response ->
                response.map{
                    Post(it.userId,it.it,it.title,it.body)
                }
            }
            .subscribe({posts->
                postAdapter = PostAdapter(posts as MutableList<Post>)
                recyclerView.adapter = postAdapter
                recyclerView.layoutManager = LinearLayoutManager(this)
                val swipeCallback = SwipeCallback(postAdapter)
                val itemTouchHelper = ItemTouchHelper(swipeCallback)
                itemTouchHelper.attachToRecyclerView(recyclerView)
            },{error->
                Log.e("apiService","API service failed. $error")
            })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        apiService  = APIService()
        recyclerView = findViewById<RecyclerView>(R.id.my_list)
        setupPostAdapter()
    }
}