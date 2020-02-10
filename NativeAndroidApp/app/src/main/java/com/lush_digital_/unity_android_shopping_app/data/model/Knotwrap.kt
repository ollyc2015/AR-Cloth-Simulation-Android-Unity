package com.lush_digital_.unity_android_shopping_app.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Knotwrap(

    @SerializedName("knotwraps")
    @Expose
    val knotwraps: List<KnotwrapIndividual>
)