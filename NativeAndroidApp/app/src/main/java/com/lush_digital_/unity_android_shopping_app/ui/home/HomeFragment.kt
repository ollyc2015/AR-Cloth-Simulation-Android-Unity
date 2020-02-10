package com.lush_digital_.unity_android_shopping_app.ui.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.lush_digital.knotwrappoc.ui.presentation.home.HomeViewModel
import com.lush_digital.knotwrappoc.ui.presentation.pagination.PaginationFragment
import com.lush_digital_.unity_android_shopping_app.R
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        clickedImage()

    }


    private fun clickedImage() {

        val fr = fragmentManager?.beginTransaction()

        knotwrap_container.setOnClickListener {

            fr?.replace(R.id.container, PaginationFragment.newInstance())
            fr?.addToBackStack(null)
            fr?.commit()

        }
    }
}
