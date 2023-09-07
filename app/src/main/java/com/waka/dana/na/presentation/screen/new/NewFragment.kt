package com.waka.dana.na.presentation.screen.new

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.waka.dana.na.R
import com.waka.dana.na.databinding.FragmentNewBinding
import com.waka.dana.na.util.setOnSafeClickListener
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * Created by hvngoc on 4/26/23
 */
class NewFragment : Fragment(), KoinComponent {

    private lateinit var binding: FragmentNewBinding
    private val viewModel: NewViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new, container, false)

        binding.buttonExit.setOnSafeClickListener({

        })
        binding.buttonSave.setOnSafeClickListener({
            val referral = binding.editId.text.toString().toIntOrNull()
            checkReferral(referral)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.checkUser.observe(viewLifecycleOwner) {
            if (it == true) {
                val referral = binding.editId.text.toString().toIntOrNull()
                saveNewUser(
                    referral,
                    binding.editName.text.toString(),
                    binding.editPrice.text.toString(),
                    binding.editNumSell.text.toString(),
                )
            } else {
                AlertDialog.Builder(requireContext())
                    .setTitle(R.string.warning)
                    .setMessage(R.string.referral_not_found)
                    .setPositiveButton(R.string.ok, null)
                    .show()
            }
        }
    }

    private fun checkReferral(id: Int?) {
        viewModel.checkUserId(id)
    }

    private fun saveNewUser(referral: Int?, name: String?, price: String?, sell: String?) {

    }
}