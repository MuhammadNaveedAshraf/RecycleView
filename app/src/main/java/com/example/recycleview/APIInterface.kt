package com.example.recycleview

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface APIInterface {

    @GET("posts")
    fun getPosts():Single<List<Post>>

}