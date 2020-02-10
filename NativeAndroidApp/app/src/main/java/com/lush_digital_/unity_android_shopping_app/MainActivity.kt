package com.lush_digital_.unity_android_shopping_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.unity3d.player.UnityPlayerActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myintent()
    }

    fun myintent(){
        val intent = Intent(this, UnityPlayerActivity::class.java)
        intent.putExtra("arguments", "KnotWrapAR")
        startActivity(intent)
    }
}
