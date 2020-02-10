package com.lush_digital_.unity_android_shopping_app


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lush_digital.knotwrappoc.ui.presentation.pagination.PaginationFragment


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    PaginationFragment.newInstance()
                )
                .commitNow()
        }
    }

    /*
    fun btnLoadUnity(){
        val intent = Intent(this, UnityPlayerActivity::class.java)
        //intent.putExtra("arguments", "KnotWrapAR")
        startActivity(intent)
    }

     */
}
