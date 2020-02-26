package com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience

import android.content.Intent
import android.graphics.Point
import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.company.product.OverrideUnityActivity
import com.lush_digital_.unity_android_shopping_app.MainActivity
import com.lush_digital_.unity_android_shopping_app.R
import com.lush_digital_.unity_android_shopping_app.data.Constants
import com.lush_digital_.unity_android_shopping_app.data.Constants.Companion.SCENE_REQUESTED
import com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.ar_menu.Menu
import com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.ar_menu.MenuHelper
import com.unity3d.player.UnityPlayer
import me.samlss.timomenu.TimoMenu
import me.samlss.timomenu.animation.FlipItemAnimation
import me.samlss.timomenu.interfaces.TimoMenuListener


class ARActivity : OverrideUnityActivity() {

    private var timoMenu: TimoMenu? = null
    private var popupMenu = Menu()
    private var playButton: Button? = null
    private var pauseButton: Button? = null
    private var menuButton: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadScene()

    }


    private fun loadScene() {
        val sceneRequest = intent?.getStringExtra(SCENE_REQUESTED)
        UnityPlayer.UnitySendMessage("HelloAR Controller", "loadScene", sceneRequest)
    }


    private fun passSelectedTextureToUnity() {
        val imageURL = intent?.getStringExtra(Constants.IMAGE_URL)
        UnityPlayer.UnitySendMessage("HelloAR Controller", "ChangeColor", imageURL)
    }


    private fun addControlsToUnityFrame() {

        val layout: FrameLayout = mUnityPlayer

        val mWidth = this.resources.displayMetrics.widthPixels
        val mHeight = this.resources.displayMetrics.heightPixels

        runOnUiThread {
            timoMenu = setUpKnotWrapSelectionMenu()

            menuButton = Button(this)
            menuButton?.background = ContextCompat.getDrawable(this, R.drawable.three_dots_menu)
            menuButton?.x = 40f
            menuButton?.y = 10f

            menuButton?.setOnClickListener { timoMenu?.show() }
            layout.addView(menuButton, 60, 150)

        }

        runOnUiThread {

            pauseButton = Button(this)
            pauseButton?.background =
                ContextCompat.getDrawable(this, android.R.drawable.ic_media_pause)
            pauseButton?.x = mWidth / 2.2f
            pauseButton?.y = mHeight / 1.15f
            pauseButton?.visibility = View.GONE
            pauseButton?.setOnClickListener { pauseAnimation() }
            layout.addView(pauseButton, 100, 190)

        }

        runOnUiThread {

            playButton = Button(this)
            playButton?.background =
                ContextCompat.getDrawable(this, android.R.drawable.ic_media_play)
            playButton?.x = mWidth / 2.2f
            playButton?.y = mHeight / 1.15f
            playButton?.visibility = View.GONE

            playButton?.setOnClickListener { playAnimation() }
            layout.addView(playButton, 60, 150)

        }
    }

    private fun pauseAnimation() {

        runOnUiThread {

            playButton?.visibility = View.VISIBLE
            pauseButton?.visibility = View.GONE

            UnityPlayer.UnitySendMessage("HelloAR Controller", "pauseAnimation", "")

        }
    }

    private fun playAnimation() {

        runOnUiThread {

            playButton?.visibility = View.GONE
            pauseButton?.visibility = View.VISIBLE

            UnityPlayer.UnitySendMessage("HelloAR Controller", "continueAnimation", "")

        }
    }


    private fun setUpKnotWrapSelectionMenu(): TimoMenu {

        val size = Point()
        windowManager.defaultDisplay.getSize(size)
        val width = size.x

        val knotwrapViewWidth = (width - 40) / 3
        val productToggleOption = (width - 40) / 3
        val knotwrapSizeOptionWidth = (width - 40) / 3

        return TimoMenu.Builder(this)
            .setGravity(Gravity.BOTTOM)
            .setTimoMenuListener(object : TimoMenuListener {
                override fun onShow() {}
                override fun onDismiss() {}
            })
            .setTimoItemClickListener { row, index, menuView ->
                Constants.CALLED_ONCE = false
                popupMenu.handleMenuSelection(
                    row,
                    index,
                    menuView,
                    applicationContext,
                    intent,
                    timoMenu,
                    pauseButton,
                    playButton,
                    menuButton
                )
            }
            .setMenuMargin(Rect(20, 20, 20, 20))
            .setMenuPadding(Rect(0, 10, 0, 10))
            .addRow(
                FlipItemAnimation.create(),
                MenuHelper.getTopList(knotwrapViewWidth, applicationContext)
            )
            .addRow(FlipItemAnimation.create(), MenuHelper.getCentreList(productToggleOption))
            .addRow(FlipItemAnimation.create(), MenuHelper.getBottomList(knotwrapSizeOptionWidth))
            .build()

    }

    override fun onPause() {
        super.onPause()

        playButton?.visibility = View.GONE
        pauseButton?.visibility = View.GONE
        UnityPlayer.UnitySendMessage("HelloAR Controller", "destroyObjects", "")

    }

    //This method is called from the Unity Library, do not remove
    fun loadedScene() {
        addControlsToUnityFrame()
        passSelectedTextureToUnity()

    }

    //This method is called from the Unity Library, do not remove
    fun showPauseButton() {

        runOnUiThread {
            pauseButton?.visibility = View.VISIBLE
            playButton?.visibility = View.GONE
        }

    }

    //This method is called from the Unity Library, do not remove
    //When the back button is pressed, go to the position the user was at in at the pagination selection screen
    fun goToPreviousScreen() {

        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_SINGLE_TOP
        startActivity(intent)

    }
}
