package com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.sceneform_ar.ar_menu

import android.content.Context
import com.lush_digital_.unity_android_shopping_app.data.RepoImpl
import com.unity3d.player.UnityPlayer
import me.samlss.timomenu.view.TimoItemView


/**
 * @author Olly Curtis
 */

class Menu {


    fun handleMenuSelection(
        row: Int,
        index: Int,
        menuView: TimoItemView,
        applicationContext: Context
    ) {

        val allLoadedKnotWraps = RepoImpl().getKnotwraps(applicationContext)


        for (i in allLoadedKnotWraps?.knotwraps?.indices!!) {
            //The below loop is needed as the knot wrap size array is smaller than the
            //allLoadedKnotWraps array. Without it, there would be a array out of bounds exception
            for (v in allLoadedKnotWraps.knotwraps[i].size?.indices!!) {


                when (menuView.textView.text) {

                    allLoadedKnotWraps.knotwraps[i].name -> {

                        val updatedKnotWrapURL = allLoadedKnotWraps.knotwraps[i].src
                        if (updatedKnotWrapURL != null) {

                            UnityPlayer.UnitySendMessage("HelloAR Controller", "ChangeColor", updatedKnotWrapURL)
                        }
                    }

                }
            }
        }
    }
}