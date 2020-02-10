package com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.sceneform_ar.ar_menu



/**
 * @author Olly Curtis
 */

class Menu {

    /*


    fun handleMenuSelection(
        row: Int,
        index: Int,
        menuView: TimoItemView,
        viewModel: ARViewModel
    ) {

        val knotwrapSelected = viewModel.getKnowrapSkeletonNode()
        val allLoadedKnotWraps = RepoImpl().getKnotwraps(viewModel.getApplication())
        val knotwrapOriginalScale = viewModel.getOriginalKWScale()

        val box = knotwrapSelected?.collisionShape as Box?
        val myBox = box?.size

        for (i in allLoadedKnotWraps?.knotwraps?.indices!!) {
            //The below loop is needed as the knot wrap size array is smaller than the
            //allLoadedKnotWraps array. Without it, there would be a array out of bounds exception
            for (v in allLoadedKnotWraps.knotwraps[i].size?.indices!!) {


                when (menuView.textView.text) {

                    allLoadedKnotWraps.knotwraps[i].name -> {

                        val updatedKnotWrapURL = allLoadedKnotWraps.knotwraps[i].src
                        if (updatedKnotWrapURL != null) {

                            viewModel.selectKnotWrap(updatedKnotWrapURL)
                        }
                    }

                    allLoadedKnotWraps.knotwraps[i].size?.get(v) -> {

                        when {
                            allLoadedKnotWraps.knotwraps[i].size?.get(v)!!.startsWith("S") -> {

                                knotwrapSelected?.localScale = knotwrapOriginalScale

                            }
                            allLoadedKnotWraps.knotwraps[i].size?.get(v)!!.startsWith("M") -> {

                                val mediumKnotwrap = viewModel.knotWrapScale(myBox, 1.2f)
                                knotwrapSelected?.localScale = mediumKnotwrap

                            }
                            else -> {

                                val largeKnotwrap = viewModel.knotWrapScale(myBox, 1.8f)
                                knotwrapSelected?.localScale = largeKnotwrap

                            }
                        }

                    }

                    viewModel.getApplication<Application>().getString(R.string.remove_all_products) -> {

                        viewModel.handleBathBombClick(menuView, index)

                    }

                    viewModel.getApplication<Application>().getString(R.string.add_one_bath_bomb) -> {

                        viewModel.handleBathBombClick(menuView, index)

                    }

                    viewModel.getApplication<Application>().getString(R.string.add_two_bath_bomb) -> {

                        viewModel.handleBathBombClick(menuView, index)

                    }

                    viewModel.getApplication<Application>().getString(R.string.add_three_bath_bomb) -> {

                        viewModel.handleBathBombClick(menuView, index)

                    }
                }
            }
        }
    }

 */
}