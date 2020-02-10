package com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.sceneform_ar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.lush_digital_.unity_android_shopping_app.R
import com.unity3d.player.UnityPlayerActivity
import kotlinx.android.synthetic.main.activity_ar.*

class ARActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar)
        btnLoadUnity()
    }

    fun btnLoadUnity(){

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            // only for Nougat and newer versions

            val intent = Intent(this, UnityPlayerActivity::class.java)
            intent.putExtra("arguments", "KnotWrapAR")
            startActivity(intent)

        }else{

           snackbar("This Feature Requires OS version Nougat and above")
        }
    }

    fun snackbar(
    message: String
    ) {
        Snackbar.make(textView1, message, Snackbar.LENGTH_LONG).show()
    }
}
