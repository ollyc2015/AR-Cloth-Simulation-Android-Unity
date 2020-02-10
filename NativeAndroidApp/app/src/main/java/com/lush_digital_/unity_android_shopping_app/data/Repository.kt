package com.lush_digital_.unity_android_shopping_app.data

import android.content.Context
import android.graphics.Bitmap
import android.os.AsyncTask
import android.widget.ImageView
import com.lush_digital_.unity_android_shopping_app.data.model.Knotwrap

interface Repository {

    fun getKnotwraps(context: Context?): Knotwrap?
    fun downloadImageTask(img_knotwrap: ImageView, imgSourceURL: String, context: Context)
    fun downloadImageTaskWithoutImageView(imgSourceURL: String): AsyncTask<String, Void, Bitmap>?

}