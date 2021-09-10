package com.nasser.appellas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.nasser.appellas.R
import com.nasser.appellas.databinding.FragmentAdminAccountsBinding
import com.nasser.appellas.databinding.FragmentRecoveryPasswordBinding
import com.nasser.appellas.ui.AppViewModel

class PasswordRecoveryFragment: Fragment() {

    private var _binding: FragmentRecoveryPasswordBinding? = null
    private val binding get() = _binding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecoveryPasswordBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }

        binding.userInputText.doAfterTextChanged { message ->
            appViewModel.userChangeInput.value = message.toString()
        }

        binding.passwordInputText.doAfterTextChanged { message ->
            appViewModel.passChangeInput.value = message.toString()
        }

        binding.newInputText.doAfterTextChanged { message ->
            appViewModel.newPassInput.value = message.toString()
        }

        binding.confirmNewInputText.doAfterTextChanged { message ->
            appViewModel.confirmNewInput.value = message.toString()
        }

        setupObservers()
        return binding.root
    }

    private fun setupObservers() {
        missingObserver()
        changeObserver()
        errorObserver()
        noObserver()
    }



    private fun missingObserver() {
        appViewModel.showMissingChangeMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowMissingChangeMessage()
            }
        })
    }

    private fun changeObserver() {
        appViewModel.showChangeMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "La contraseña ha sido actualizada!", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowChangeMessage()
            }
        })
    }

    private fun errorObserver() {
        appViewModel.showErrorChangeMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "La contraseña nueva no coincide", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowErrorChangeMessage()
            }
        })
    }

    private fun noObserver() {
        appViewModel.showNoChangeMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "La contraseña antigua no coincide", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowNoChangeMessage()
            }
        })
    }
}