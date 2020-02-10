package com.lush_digital_.unity_android_shopping_app.data

import android.content.Context
import android.graphics.Bitmap
import android.os.AsyncTask
import android.widget.ImageView
import com.lush_digital_.unity_android_shopping_app.async.DownloadImageTask
import com.lush_digital_.unity_android_shopping_app.async.GetJson
import com.lush_digital_.unity_android_shopping_app.data.model.Knotwrap

class RepoImpl : Repository {

    private val knotwraps = GetJson()

    override fun getKnotwraps(context: Context?): Knotwrap? {

        return knotwraps.getJson(context)
    }

    override fun downloadImageTask(
        img_knotwrap: ImageView,
        imgSourceURL: String,
        context: Context
    ) {

        val download = DownloadImageTask()
        download.bmImage = img_knotwrap
        download.downloadImageWithGlide(imgSourceURL, context)

    }

    override fun downloadImageTaskWithoutImageView(imgSourceURL: String): AsyncTask<String, Void, Bitmap>? {

        return DownloadImageTask()
            .execute(imgSourceURL)
    }
}