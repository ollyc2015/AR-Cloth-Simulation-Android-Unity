package com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.sceneform_ar.ar_menu


/**
 * @author Olly Curtis

 */
object MenuHelper {

    /*

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
        val removeAllProducts = getTimoItemViewParameterOther(
            itemWidth, R.drawable.ic_notification_clear_all,
            R.drawable.ic_notification_clear_all, R.string.remove_all_products, R.color.colorAccent,
            R.color.colorPrimary
        )
        val bathBomb1 = getTimoItemViewParameterOther(
            itemWidth, R.drawable.harajuku,
            R.drawable.harajuku, R.string.add_one_bath_bomb, R.color.colorAccent,
            R.color.colorPrimary
        )
        val bathBomb2 = getTimoItemViewParameterOther(
            itemWidth, R.drawable.two_bathbombs,
            R.drawable.two_bathbombs, R.string.add_two_bath_bomb, R.color.colorAccent,
            R.color.colorPrimary
        )
        val bathBomb3 = getTimoItemViewParameterOther(
            itemWidth, R.drawable.three_bath_bombs,
            R.drawable.three_bath_bombs, R.string.add_three_bath_bomb, R.color.colorAccent,
            R.color.colorPrimary
        )


        listCentre.add(removeAllProducts)
        listCentre.add(bathBomb1)
        listCentre.add(bathBomb2)
        listCentre.add(bathBomb3)
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

     */

}