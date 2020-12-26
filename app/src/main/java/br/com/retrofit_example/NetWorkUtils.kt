package br.com.retrofit_example

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class NetWorkUtils {

    companion object {
        fun getRtrofitInstance(path: String): Retrofit {
            return Retrofit.Builder().baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create()).build()


        }


    }
    interface  EndPoint {
        @GET("posts")
        fun getPosts():Call<List<PostModel.Posts>>

    }
}
