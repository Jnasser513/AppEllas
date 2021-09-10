package com.nasser.appellas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.nasser.appellas.databinding.FragmentAlertaBinding
import com.nasser.appellas.ui.AppViewModel

class AlertaFragment: Fragment() {

    private var _binding: FragmentAlertaBinding? = null
    private val binding get() = _binding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlertaBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }
}

