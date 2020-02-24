package com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.ar_menu

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import com.lush_digital_.unity_android_shopping_app.R
import com.lush_digital_.unity_android_shopping_app.data.Constants
import com.lush_digital_.unity_android_shopping_app.data.Constants.Companion.CALLED_ONCE
import com.lush_digital_.unity_android_shopping_app.data.RepoImpl
import com.unity3d.player.UnityPlayer
import me.samlss.timomenu.TimoMenu
import me.samlss.timomenu.view.TimoItemView


/**
 * @author Olly Curtis
 */

class Menu {


    fun handleMenuSelection(
        row: Int,
        index: Int,
        menuView: TimoItemView,
        applicationContext: Context,
        intent: Intent,
        timoMenu: TimoMenu?,
        pauseButton: Button?,
        playButton: Button?,
        menuButton: Button?
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

                            intent.putExtra(Constants.IMAGE_URL, updatedKnotWrapURL)
                            UnityPlayer.UnitySendMessage("HelloAR Controller", "ChangeColor", updatedKnotWrapURL)
                        }
                    }

                    applicationContext.getString(R.string.animation_one) -> {

                        if(!CALLED_ONCE) {

                            CALLED_ONCE = true
                            pauseButton?.visibility = View.GONE
                            playButton?.visibility = View.GONE
                            menuButton?.visibility = View.GONE
                            timoMenu?.dismiss()
                            UnityPlayer.UnitySendMessage("HelloAR Controller", "loadScene", "1")
                        }


                    }

                    applicationContext.getString(R.string.animation_two) -> {

                        if(!CALLED_ONCE) {

                            CALLED_ONCE = true
                            pauseButton?.visibility = View.GONE
                            playButton?.visibility = View.GONE
                            menuButton?.visibility = View.GONE
                            timoMenu?.dismiss()
                            UnityPlayer.UnitySendMessage("HelloAR Controller", "loadScene", "2")
                        }
                    }


                    allLoadedKnotWraps.knotwraps[i].size?.get(v) -> {

                        when {
                            allLoadedKnotWraps.knotwraps[i].size?.get(v)!!.startsWith("S") -> {

                                UnityPlayer.UnitySendMessage("HelloAR Controller", "smallKW", "")

                            }
                            allLoadedKnotWraps.knotwraps[i].size?.get(v)!!.startsWith("M") -> {

                                UnityPlayer.UnitySendMessage("HelloAR Controller", "mediumKW", "")

                            }
                            else -> {

                                UnityPlayer.UnitySendMessage("HelloAR Controller", "largeKW", "")

                            }
                        }

                    }

                }
            }
        }
    }
}