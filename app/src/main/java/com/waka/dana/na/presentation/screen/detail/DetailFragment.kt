package com.waka.dana.na.presentation.screen.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.waka.dana.na.R
import com.waka.dana.na.databinding.FragmentDetailBinding
import org.koin.core.component.KoinComponent

/**
 * Created by hvngoc on 4/26/23
 */
class DetailFragment : Fragment(), KoinComponent {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        return binding.root
    }
}