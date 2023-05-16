package com.waka.dana.na.presentation.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.waka.dana.na.R
import com.waka.dana.na.databinding.FragmentHomeBinding
import com.waka.dana.na.presentation.base.MasterController
import com.waka.dana.na.presentation.base.MasterEpoxyBuilder
import com.waka.dana.na.util.visibleIf
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.component.KoinComponent

/**
 * Created by hvngoc on 4/26/23
 */
class HomeFragment : Fragment(), KoinComponent, MasterEpoxyBuilder {

    companion object {
        private const val DELAY_TIME = 1000L
        const val TAG = "FragmentHome"
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    private val controller by lazy { MasterController(this) }
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModel()

    private val debounce = Runnable {
        val length = homeViewModel.lastQuery?.length ?: 0
        if (length >= 3) {
            showContent(loading = true)
            homeViewModel.loadData(homeViewModel.lastQuery)
        } else {
            showContent(empty = true)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        showContent(empty = true)
        binding.recyclerView.setController(controller)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                LinearLayout.VERTICAL
            )
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.editText.doAfterTextChanged {
            homeViewModel.lastQuery = it?.toString()
            binding.editText.removeCallbacks(debounce)
            binding.editText.postDelayed(debounce, DELAY_TIME)
        }
    }


    private fun showContent(
        content: Boolean = false,
        error: Boolean = false,
        empty: Boolean = false,
        loading: Boolean = false
    ) {
        binding.recyclerView.visibleIf(content)
        binding.error.visibleIf(error)
        binding.noResult.visibleIf(empty)
        binding.loading.visibleIf(loading)

    }

    override fun buildHolder(): List<EpoxyModelWithHolder<*>> {
        TODO("Not yet implemented")
    }
}