package com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.ar_menu

import android.content.Context
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import com.lush_digital_.unity_android_shopping_app.R
import com.lush_digital_.unity_android_shopping_app.data.RepoImpl
import me.samlss.timomenu.TimoItemViewParameter


/**
 * @author Olly Curtis

 */
object MenuHelper {



    fun getTopList(itemWidth: Int, context: Context): List<TimoItemViewParameter> {

        val allKnotWraps = RepoImpl().getKnotwraps(context)?.knotwraps

        val listTop: MutableList<TimoItemViewParameter> =
            ArrayList()


        if (allKnotWraps != null) {
            for (i in allKnotWraps.indices) {

                val myBitmap = RepoImpl().downloadImageTaskWithoutImageView(allKnotWraps[i].src.toString())

                val d: Drawable = BitmapDrawable(context.resources, myBitmap?.get())

                val knotWraps = getTimoItemViewParameter(
                    itemWidth, d,d,
                    allKnotWraps[i].name.toString(), R.color.colorAccent,
                    R.color.colorPrimary
                )

                listTop.add(knotWraps)
            }
        }

        return listTop
    }


    fun getCentreList(itemWidth: Int): List<TimoItemViewParameter> {
        val listCentre: MutableList<TimoItemViewParameter> =
            ArrayList()
        val simulation1 = getTimoItemViewParameterOther(
            itemWidth, R.drawable.animation_one,
            R.drawable.animation_one, R.string.animation_one, R.color.colorAccent,
            R.color.colorPrimary
        )
        val simulation2 = getTimoItemViewParameterOther(
            itemWidth, R.drawable.animation_two,
            R.drawable.animation_two, R.string.animation_two, R.color.colorAccent,
            R.color.colorPrimary
        )

        listCentre.add(simulation1)
        listCentre.add(simulation2)
        return listCentre
    }



    fun getBottomList(itemWidth: Int): List<TimoItemViewParameter>? {
        val listBottom: MutableList<TimoItemViewParameter> = ArrayList()
        val sizeSmall = getTimoItemViewParameterOther(
            itemWidth, R.drawable.small,
            R.drawable.small, R.string.size_small, R.color.colorAccent,
            R.color.colorPrimary
        )
        val sizeMedium = getTimoItemViewParameterOther(
            itemWidth, R.drawable.medium,
            R.drawable.medium, R.string.size_medium, R.color.colorAccent,
            R.color.colorPrimary
        )
        val sizeLarge = getTimoItemViewParameterOther(
            itemWidth, R.drawable.large,
            R.drawable.medium, R.string.size_large, R.color.colorAccent,
            R.color.colorPrimary
        )

        listBottom.add(sizeSmall)
        listBottom.add(sizeMedium)
        listBottom.add(sizeLarge)
        return listBottom
    }




    private fun getTimoItemViewParameter(
        itemWidth: Int,
        normalImageRes: Drawable,
        highlightImageRes: Drawable,
        normalTextRes: String,
        normalTextColorRes: Int,
        highlightTextColorRes: Int
    ): TimoItemViewParameter {
        return TimoItemViewParameter.Builder()
            .setWidth(itemWidth)
            .setImagePadding(Rect(10, 10, 10, 10))
            .setTextPadding(Rect(5, 0, 5, 0))
            .setNormalImageDrawable(normalImageRes)
            .setHighlightedImageDrawable(highlightImageRes)
            .setNormalText(normalTextRes)
            .setNormalTextColorRes(normalTextColorRes)
            .setHighlightedTextColorRes(highlightTextColorRes)
            .build()
    }

    private fun getTimoItemViewParameterOther(
        itemWidth: Int,
        normalImageRes: Int,
        highlightImageRes: Int,
        normalTextRes: Int,
        normalTextColorRes: Int,
        highlightTextColorRes: Int
    ): TimoItemViewParameter {
        return TimoItemViewParameter.Builder()
            .setWidth(itemWidth)
            .setImagePadding(Rect(10, 10, 10, 10))
            .setTextPadding(Rect(5, 0, 5, 0))
            .setNormalImageRes(normalImageRes)
            .setHighlightedImageRes(highlightImageRes)
            .setNormalTextRes(normalTextRes)
            .setNormalTextColorRes(normalTextColorRes)
            .setHighlightedTextColorRes(highlightTextColorRes)
            .build()
    }
}