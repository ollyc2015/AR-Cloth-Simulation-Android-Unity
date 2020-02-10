package com.lush_digital_.unity_android_shopping_app.utils

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View

class AndroidUtils {

    companion object {

        fun animateView(view: View, toVisibility: Int, toAlpha: Float, duration: Long) {
            val show = toVisibility == View.VISIBLE
            if (show) {
                view.setAlpha(0f)
            }
            view.visibility = View.VISIBLE
            view.animate()
                .setDuration(duration)
                .alpha(if (show) toAlpha else 0f)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        view.visibility = toVisibility
                    }
                })
        }
    }
}