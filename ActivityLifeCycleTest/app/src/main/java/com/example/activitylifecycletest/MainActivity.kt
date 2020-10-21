package com.example.activitylifecycletest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startNormalActivity.setOnClickListener {
            val intent = Intent(this, NormalActivity::class.java)
            startActivity(intent)
        }
        startDialogActivity.setOnClickListener {
            val intent = Intent(this, DialogActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("tag", "On start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("tag", "On resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("tag", "On pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("tag", "On stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("tag", "On destroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("tag", "On restart")
    }
}