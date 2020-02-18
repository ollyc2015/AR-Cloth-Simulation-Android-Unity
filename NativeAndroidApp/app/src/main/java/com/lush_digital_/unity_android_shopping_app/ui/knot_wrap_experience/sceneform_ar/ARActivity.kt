package com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.sceneform_ar

import android.content.Intent
import android.graphics.Point
import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import com.company.product.OverrideUnityActivity
import com.lush_digital.knotwrappoc.ui.presentation.pagination.PaginationFragment
import com.lush_digital_.unity_android_shopping_app.R
import com.lush_digital_.unity_android_shopping_app.data.Constants
import com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.sceneform_ar.ar_menu.Menu
import com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.sceneform_ar.ar_menu.MenuHelper
import com.unity3d.player.UnityPlayer
import me.samlss.timomenu.TimoMenu
import me.samlss.timomenu.animation.FlipItemAnimation
import me.samlss.timomenu.interfaces.TimoMenuListener

class ARActivity : OverrideUnityActivity() {

    private var timoMenu: TimoMenu? = null
    private var popupMenu = Menu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addControlsToUnityFrame()
        passSelectedTextureToUnity()
    }

    private fun passSelectedTextureToUnity() {
        val imageURL = intent?.getStringExtra(Constants.IMAGE_URL)
        UnityPlayer.UnitySendMessage("HelloAR Controller", "ChangeColor", imageURL)
    }

    override fun showMainActivity() {
        val intent = Intent(this, PaginationFragment::class.java)
        startActivity(intent)
    }

    private fun addControlsToUnityFrame() {

        val layout: FrameLayout = mUnityPlayer

        run{
            timoMenu = setUpKnotWrapSelectionMenu()

            val myButton = Button(this)
            myButton.background = ContextCompat.getDrawable(this, R.drawable.three_dots_menu)
            myButton.x = 40f
            myButton.y = 10f

            myButton.setOnClickListener { timoMenu?.show() }
            layout.addView(myButton, 60, 150)

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
                popupMenu.handleMenuSelection(row, index, menuView, applicationContext)
            }
            .setMenuMargin(Rect(20, 20, 20, 20))
            .setMenuPadding(Rect(0, 10, 0, 10))
            .addRow(FlipItemAnimation.create(), MenuHelper.getTopList(knotwrapViewWidth, applicationContext))
            .addRow(FlipItemAnimation.create(), MenuHelper.getCentreList(productToggleOption))
            .addRow(FlipItemAnimation.create(), MenuHelper.getBottomList(knotwrapSizeOptionWidth))
            .build()

    }

    override fun onUnityPlayerQuitted() {
        showMainActivity()
        finish()
    }
}
