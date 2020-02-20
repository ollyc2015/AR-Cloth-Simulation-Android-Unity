package com.lush_digital.knotwrappoc.ui.presentation.pagination

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.lush_digital_.unity_android_shopping_app.R
import com.lush_digital_.unity_android_shopping_app.ui.basket.BasketFragment
import com.lush_digital_.unity_android_shopping_app.ui.pagination.viewpager.CubeOutRotationTransformation
import com.lush_digital_.unity_android_shopping_app.ui.pagination.PaginationViewModel
import com.rd.animation.type.AnimationType
import kotlinx.android.synthetic.main.pagination_fragment.*

/**
 * @author Olly Curtis
 */

class PaginationFragment : Fragment() {

    private lateinit var demoCollectionPagerAdapter: PaginationViewModel.DemoCollectionPagerAdapter
    private lateinit var cubeOutRotationTransformation: CubeOutRotationTransformation
    private lateinit var viewPager: ViewPager


    companion object {
        fun newInstance() = PaginationFragment()
    }

    private lateinit var viewModel: PaginationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.pagination_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PaginationViewModel::class.java)
        init()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Show progress overlay (with animation):
        demoCollectionPagerAdapter =
            PaginationViewModel.DemoCollectionPagerAdapter(childFragmentManager, context!!)

        cubeOutRotationTransformation = CubeOutRotationTransformation()

        viewPager = view.findViewById(R.id.pager)
        viewPager.setPageTransformer(true, cubeOutRotationTransformation)
        viewPager.adapter = demoCollectionPagerAdapter

    }

    private fun init() {

        getCurrentPage()
        pageIndicator()
    }

    fun pageIndicator() {
        //Page indicator
        val pageIndicatorView = pageIndicatorView
        pageIndicatorView.setViewPager(viewPager)
        pageIndicatorView.setInteractiveAnimation(true)
        pageIndicatorView.setAnimationType(AnimationType.DROP)
        pageIndicatorView.setAutoVisibility(true)
        pageIndicatorView.setDynamicCount(true)
    }


    private fun getCurrentPage(

    ) {

        this.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            //declare key
            var first = true

            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {


                if (first && positionOffset == 0f && positionOffsetPixels == 0) {
                    onPageSelected(0)
                    first = false
                }

            }

            override fun onPageSelected(position: Int) {

                val fragmentManager: FragmentManager? = null

                val fr = fragmentManager?.beginTransaction()

                when (position) {


                    0 -> {

                        btn_add_to_basket.setOnClickListener {

                            fr?.replace(R.id.container, BasketFragment.newInstance())
                            fr?.addToBackStack(null)
                            fr?.commit()
                        }
                    }
                    1 -> {

                        btn_add_to_basket.setOnClickListener {

                            fr?.replace(R.id.container, BasketFragment.newInstance())
                            fr?.addToBackStack(null)
                            fr?.commit()

                        }

                    }
                    else -> {

                        btn_add_to_basket.setOnClickListener {

                            fr?.replace(R.id.container, BasketFragment.newInstance())
                            fr?.addToBackStack(null)
                            fr?.commit()

                        }

                    }
                }
            }
        })

    }
}
