package com.lush_digital_.unity_android_shopping_app.ui.pagination

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.ViewModel
import com.lush_digital_.unity_android_shopping_app.R
import com.lush_digital_.unity_android_shopping_app.data.Constants.Companion.IMAGE_URL
import com.lush_digital_.unity_android_shopping_app.data.Constants.Companion.SCENE_REQUESTED
import com.lush_digital_.unity_android_shopping_app.data.RepoImpl
import com.lush_digital_.unity_android_shopping_app.data.model.KnotwrapIndividual
import com.lush_digital_.unity_android_shopping_app.ui.knot_wrap_experience.ARActivity
import com.lush_digital_.unity_android_shopping_app.utils.AndroidUtils
import kotlinx.android.synthetic.main.include_progress_overlay.*
import kotlinx.android.synthetic.main.pager_item.*


/**
 * @author Olly Curtis
 */

class PaginationViewModel : ViewModel() {

    // Since this is an object collection, use a FragmentStatePagerAdapter,
    // and NOT a FragmentPagerAdapter.
    @Suppress("UNCHECKED_CAST")
    class DemoCollectionPagerAdapter(fm: FragmentManager, context: Context) :
        FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        private var knotwrapImpl = RepoImpl()
        private val myobject = knotwrapImpl.getKnotwraps(context)

        override fun getCount(): Int = myobject?.knotwraps?.size!!

        override fun getItem(position: Int): Fragment {

            val imgSourceURL = myobject?.knotwraps?.get(position)?.src
            val allKnotWraps = myobject?.knotwraps


            if (allKnotWraps != null) {

                return DemoObjectFragment.newInstance(
                    allKnotWraps[position].name,
                    imgSourceURL,
                    allKnotWraps
                )!!

            }

            return Fragment()
        }

        // Instances of this class are fragments representing a single
        // object in our collection.
        class DemoObjectFragment : Fragment() {

            companion object {
                fun newInstance(
                    knotWrapName: String?,
                    imgSourceURL: String?,
                    allKnotWraps: List<KnotwrapIndividual>?
                ): DemoObjectFragment? {
                    val f = DemoObjectFragment()
                    val b = Bundle()
                    b.putString("knotWrapName", knotWrapName)
                    b.putString("imgSourceURL", imgSourceURL)
                    b.putParcelableArrayList(
                        "allKnotWraps",
                        allKnotWraps as ArrayList<out Parcelable>?
                    )
                    f.arguments = b
                    return f
                }
            }

            override fun onCreateView(
                inflater: LayoutInflater,
                container: ViewGroup?,
                savedInstanceState: Bundle?
            ): View {

                return inflater.inflate(R.layout.pager_item, container, false)
            }


            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

                val imgSourceURL = arguments!!.getString("imgSourceURL")
                val knotWrapName = arguments!!.getString("knotWrapName")
                val allKnotWraps =
                    arguments?.getSerializable("allKnotWraps") as? List<KnotwrapIndividual>



                context?.let {
                    RepoImpl().downloadImageTask(img_knotwrap, imgSourceURL.toString(),
                        it
                    )
                }

                val progressOverlay = progress_overlay

                // Hide it (with animation):
                AndroidUtils.animateView(progressOverlay, View.GONE, 0f, 200)


                img_knotwrap.contentDescription = imgSourceURL.toString()

                setupUI(knotWrapName, allKnotWraps)

                img_knotwrap.setOnClickListener {

                    showDialog(
                        it,
                        knotWrapName,
                        imgSourceURL,
                        progressOverlay
                    )
                }


            }


            private fun setupUI(
                knotWrapName: String?,
                allKnotWraps: List<KnotwrapIndividual>?
            ) {

                if (allKnotWraps != null) {

                    for (i in allKnotWraps.indices) {

                        when (knotWrapName) {

                            allKnotWraps[i].name -> {
                                tv_product_name.text = allKnotWraps[i].name
                                tv_cost.text = allKnotWraps[i].price

                            }
                        }
                    }
                } else {

                    toast("No Knot-Wraps to view")
                }
            }

            private fun showDialog(
                it: View,
                knotWrapName: String?,
                imgSourceURL: String?,
                progressOverlay: FrameLayout
            ) {
                // Show progress overlay (with animation):
                AndroidUtils.animateView(progressOverlay, View.VISIBLE, 0.4f, 0)

                // Late initialize an alert dialog object
                lateinit var dialog: AlertDialog

                // Initialize an array of colors
                val arrayOptions =
                    arrayOf(getString(R.string.three_d_mode), getString(R.string.ar_mode))

                // Initialize a boolean array of checked items
                val arrayChecked = booleanArrayOf(false, false)

                // Initialize a new instance of alert dialog builder object
                val builder = AlertDialog.Builder(activity)

                // Set a title for alert dialog
                builder.setTitle("How would you like to view $knotWrapName knot-wrap?")

                // Define multiple choice items for alert dialog
                builder.setMultiChoiceItems(arrayOptions, arrayChecked) { _, which, isChecked ->

                    // Update the clicked item checked status
                    val listView: ListView = dialog.listView

                    //If the user checks a box and then unchecks the box do below
                    if (!arrayChecked[which]) {

                        arrayChecked[which] = !isChecked

                    } else {

                        //if a selection is made, uncheck other options
                        for (i in arrayChecked.indices) {
                            listView.setItemChecked(i, !isChecked)
                            arrayChecked[i] = !isChecked
                        }

                        arrayChecked[which] = isChecked
                    }

                }

                builder.setOnDismissListener {

                    AndroidUtils.animateView(progressOverlay, View.GONE, 0f, 0)
                }

                // Set the positive/yes button click listener
                builder.setPositiveButton("OK") { _, _ ->

                    handlePostiveButtonClick(
                        it,
                        arrayOptions,
                        arrayChecked,
                        imgSourceURL,
                        progressOverlay
                    )
                }

                // Initialize the AlertDialog using builder object
                dialog = builder.create()

                // Finally, display the alert dialog
                dialog.show()
            }


            private fun handlePostiveButtonClick(
                it: View,
                arrayOptions: Array<String>,
                arrayChecked: BooleanArray,
                imgSourceURL: String?,
                progressOverlay: FrameLayout
            ) {

                for (i in arrayOptions.indices) {
                    val checked = arrayChecked[i]
                    if (checked) {

                        when { //Check which option was selected by the user (3D or AR)

                            it.contentDescription.toString() == imgSourceURL.toString()
                                    && arrayOptions[i] == getString(R.string.three_d_mode) -> {

                                AndroidUtils.animateView(progressOverlay, View.GONE, 0f, 200)
                                toast("Feature Coming Soon")

                               // val intent = Intent(activity, SceneviewActivity::class.java)
                               // intent.putExtra(IMAGE_URL, imgSourceURL)
                               // startActivity(intent)
                            }
                            it.contentDescription.toString() == imgSourceURL.toString()
                                    && arrayOptions[i] == getString(R.string.ar_mode) -> {

                                AndroidUtils.animateView(progressOverlay, View.GONE, 0f, 200)

                                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {

                                    val intent = Intent(activity, ARActivity::class.java)
                                    intent.putExtra(IMAGE_URL, imgSourceURL)
                                    intent.putExtra(SCENE_REQUESTED, "1")
                                    intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
                                    startActivity(intent)

                                }else{

                                    toast("This Feature Requires OS version Nougat and above")
                                }

                            }

                            else -> {

                                toast("Error occurred")
                            }
                        }

                    }
                }

            }

            // Extension function to show toast message
            private fun toast(message: String) {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()


            }
        }
    }
}

