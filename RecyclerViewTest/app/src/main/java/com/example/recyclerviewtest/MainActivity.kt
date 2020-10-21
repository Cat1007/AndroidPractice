package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.listviewtest.Fruit
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()

    private fun initFruit() {
        repeat(4) {
            fruitList.add(Fruit(getRandomLengthString("APPLE"), R.drawable.img1))
            fruitList.add(Fruit(getRandomLengthString("PEAR"), R.drawable.img1))
            fruitList.add(Fruit(getRandomLengthString("ORANGE"), R.drawable.img1))
            fruitList.add(Fruit(getRandomLengthString("WATER"), R.drawable.img1))
        }
    }

    private fun getRandomLengthString(str: String): String {
        val n = (1..20).random()
        val builder = StringBuilder()
        repeat(n) {
            builder.append(str)
        }
        return builder.toString()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruit()
        val layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        val adapter = FruitAdapter(fruitList)
        recyclerView.adapter = adapter
    }
}