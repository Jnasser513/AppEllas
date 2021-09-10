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
import com.nasser.appellas.databinding.FragmentSeccionjuridicaBinding
import com.nasser.appellas.ui.AppViewModel

class SeccionJuridicaFragment: Fragment() {

    private var _binding: FragmentSeccionjuridicaBinding? = null
    private val binding get() = _binding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSeccionjuridicaBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }
        setUpObservers()
        return binding.root
    }

    private fun setUpObservers(){
        callObserver()
        messageObserver()
    }

    //Cuando se de click se activa el observer y inicia el Intent para cambiar al telefono celular
    private fun callObserver() {
        appViewModel.showCall.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    startActivity(Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel: 71901254")))
                }
                appViewModel.endShowCall()
            }
        })
    }

    private fun messageObserver() {
        appViewModel.showMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    startActivity(Intent(Intent.ACTION_SEND).setData(Uri.parse("smsto: 71901254")))
                }
                appViewModel.endShowMessage()
            }
        })
    }
}