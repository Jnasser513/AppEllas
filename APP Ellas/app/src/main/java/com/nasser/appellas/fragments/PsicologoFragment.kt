package com.nasser.appellas.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.nasser.appellas.R
import com.nasser.appellas.databinding.FragmentAdminAccountsBinding
import com.nasser.appellas.databinding.FragmentPsicologoBinding
import com.nasser.appellas.ui.AppViewModel

class PsicologoFragment: Fragment() {

    private var _binding: FragmentPsicologoBinding? = null
    private val binding get() = _binding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPsicologoBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }
        setUpObservers()
        return binding.root
    }

    private fun setUpObservers() {
        callObserver()
        messageObserver()
    }

    private fun callObserver() {
        appViewModel.showCall.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    startActivity(Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel: 76031382")))
                }
                appViewModel.endShowCall()
            }
        })
    }

    private fun messageObserver() {
        appViewModel.showMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    startActivity(Intent(Intent.ACTION_SEND).setData(Uri.parse("smsto: 76031382")))
                }
                appViewModel.endShowMessage()
            }
        })
    }
}