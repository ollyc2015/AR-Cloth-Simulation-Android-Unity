package com.lush_digital_.unity_android_shopping_app.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import java.io.Serializable

class KnotwrapIndividual: JSONArray(), Serializable {
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("src")
    @Expose
    val src: String? = null
    @SerializedName("price")
    @Expose
    val price: String? = null
    @SerializedName("size")
    @Expose
    val size: List<String>? = null
}