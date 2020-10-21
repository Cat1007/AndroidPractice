package com.example.databasetest

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val dbHelper = MyDatabaseHelper(this, "BookStore.db", 2)
        create.setOnClickListener {
            dbHelper.writableDatabase
        }

        add.setOnClickListener {
            val db = dbHelper.writableDatabase
            val value1 = ContentValues().apply {
                put("name", "daddy is")
                put("author", "john wick")
                put("pages", 134)
                put("price", 16.29)
            }
            val value2 = ContentValues().apply {
                put("name", "sleep sheep")
                put("author", "john wick")
                put("pages", 768)
                put("price", 45.242)
            }
            db.insert("Book", null, value1)
            db.insert("Book", null, value2)
        }

        update.setOnClickListener {
            val db = dbHelper.writableDatabase
            val value = ContentValues()
            value.put("price", 10.99)

            db.update("Book", value, "name = ?", arrayOf("mama"))
            Toast.makeText(this, "updated", Toast.LENGTH_SHORT).show()
        }

        delete.setOnClickListener {
            val db = dbHelper.writableDatabase
            db.delete("Book","pages > ?", arrayOf("400"))
        }

        query.setOnClickListener {
            val db = dbHelper.readableDatabase
            val cursor = db.query("Book",null,null,null,null,null,null,null)
            if(cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndex("name"))
                    val author = cursor.getString(cursor.getColumnIndex("author"))
                    val pages = cursor.getInt(cursor.getColumnIndex("pages"))
                    val price = cursor.getDouble(cursor.getColumnIndex("price"))
                    Log.d("MainActivity", "$name   $author   $pages   $price")
                } while (cursor.moveToNext())
            }
            cursor.close()
        }
    }
}