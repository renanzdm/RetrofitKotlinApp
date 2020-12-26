package br.com.retrofit_example

import com.google.gson.annotations.SerializedName

class PostModel {


    data class Posts(
        @SerializedName("userId")
        var userId : Int,
        @SerializedName("id")
        var id : Int,
        @SerializedName("title")
        var title : String,
        @SerializedName("body")
        var body : String
    )
}