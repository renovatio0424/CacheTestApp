package com.reno.cachetestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.textView)
        button.setOnClickListener {
            lifecycleScope.launch {
                val result = postManService(applicationContext).getCacheTest()
                Log.d("result", "result: $result")
            }
        }
    }
}