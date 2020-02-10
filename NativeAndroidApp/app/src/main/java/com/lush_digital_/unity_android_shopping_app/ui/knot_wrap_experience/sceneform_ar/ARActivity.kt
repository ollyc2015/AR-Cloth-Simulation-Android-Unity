package com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.sceneform_ar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lush_digital_.unity_android_shopping_app.R
import com.unity3d.player.UnityPlayerActivity

class ARActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar)
        btnLoadUnity()
    }


    fun btnLoadUnity(){
        val intent = Intent(this, UnityPlayerActivity::class.java)
        intent.putExtra("arguments", "KnotWrapAR")
        startActivity(intent)
    }
}
