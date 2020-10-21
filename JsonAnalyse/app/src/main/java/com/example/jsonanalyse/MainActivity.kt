package com.example.jsonanalyse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.jsonanalyse.serverapi.AppService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {
    private var data: ArrayList<MyData> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = MyDataAdapter(this, R.layout.json_item, data)
        listView.adapter = adapter
        get.setOnClickListener {
            val appService = ServiceCreator.create<AppService>()
            appService.getData().enqueue(object : Callback<MyDataList> {
                override fun onResponse(call: Call<MyDataList>, response: Response<MyDataList>) {
                    val list = response.body()?.data
                    list?.let {
                        data.removeAll(data)
                        for (item in list) {
                            data.add(item)
                        }
                        adapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<MyDataList>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }
    }
}