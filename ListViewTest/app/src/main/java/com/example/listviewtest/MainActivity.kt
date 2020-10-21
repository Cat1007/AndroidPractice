package com.example.listviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val data = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFruit()
        val adapter = FruitAdapter(this, R.layout.friut_item, data)
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->
            val fruit = data[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
            data.removeAt(data.lastIndex - 1)
            adapter.notifyDataSetChanged()
        }
    }

    private fun initFruit() {
        repeat(3) {
            data.add(Fruit("apple", R.drawable.img1))
            data.add(Fruit("banana", R.drawable.img1))
            data.add(Fruit("pear", R.drawable.img1))
            data.add(Fruit("watermelon", R.drawable.img1))
            data.add(Fruit("cat", R.drawable.img1))
            data.add(Fruit("dog", R.drawable.img1))
            data.add(Fruit("kkkkkk", R.drawable.img1))
        }
    }
}