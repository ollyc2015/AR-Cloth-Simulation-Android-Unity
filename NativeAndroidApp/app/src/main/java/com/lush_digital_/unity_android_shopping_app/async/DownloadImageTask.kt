package com.lush_digital_.unity_android_shopping_app.async

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.lush_digital_.unity_android_shopping_app.R
import java.net.URL


class DownloadImageTask: AsyncTask<String, Void, Bitmap>()  {

     var bmImage: ImageView? = null

    override fun doInBackground(vararg urls: String): Bitmap? {
        val urldisplay = urls[0]
        var mIcon11: Bitmap? = null
        try {
            val input = URL(urldisplay).openStream()
            mIcon11 = BitmapFactory.decodeStream(input)
        } catch (e: Exception) {
            Log.e("Error", e.message.toString())
            e.printStackTrace()
        }
        return mIcon11
    }

    override fun onPostExecute(result: Bitmap) {

        if(bmImage!= null) {
            bmImage?.setImageBitmap(result)
        }
    }



    fun downloadImageWithGlide(imgSourceURL: String, context: Context) {

        val requestOption = RequestOptions()
            .placeholder(R.drawable.image_placeholder).centerCrop()
        bmImage?.let {
            Glide.with(context)
                .load(imgSourceURL)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(requestOption)
                .into(it)

        }
    }
}


