package com.lush_digital_.unity_android_shopping_app.async

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.lush_digital_.unity_android_shopping_app.data.model.Knotwrap
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset


class GetJson {

    fun getJson(context: Context?): Knotwrap? {

        var knotwraps: Knotwrap? = null
        val json: String?
        val gson = Gson()

        try {

            val myFile = context?.assets?.open("knotwrap_response.json")
            val size = myFile?.available()
            val buffer = ByteArray(size!!)
            myFile.read(buffer)
            myFile.close()

            json = String(buffer, Charset.forName("UTF-8"))

            knotwraps = gson.fromJson(json, Knotwrap::class.java)

            return knotwraps


        } catch (e: IOException) {

            Log.e("Error", "Error: $e")

        } catch (e: JSONException) {

            Log.e("JSON Error", "Error: $e")
        }
        return knotwraps
    }
}
