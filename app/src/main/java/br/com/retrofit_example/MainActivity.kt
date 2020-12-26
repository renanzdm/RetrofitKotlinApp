package br.com.retrofit_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
    }

    private fun getData() {
        val retrofitClient = NetWorkUtils.getRtrofitInstance("https://jsonplaceholder.typicode.com")


        val endpoint = retrofitClient.create(NetWorkUtils.EndPoint::class.java)
        val callback = endpoint.getPosts()

        callback.enqueue(object : Callback<List<PostModel.Posts>> {
            override fun onFailure(call: Call<List<PostModel.Posts>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<PostModel.Posts>>, response: Response<List<PostModel.Posts>>) {
                val textView : TextView = findViewById(R.id.textViewResult)

                response.body()?.forEach {

                    textView.text = textView.text.toString().plus(it.body)
                }
            }
        })

    }




}