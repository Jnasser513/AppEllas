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
import com.nasser.appellas.databinding.FragmentRegisterBinding
import com.nasser.appellas.ui.AppViewModel

class RegisterFragment: Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }

        binding.emailEditText.doAfterTextChanged { message ->
            appViewModel.emailInput.value = message.toString()
        }

        binding.userEditText.doAfterTextChanged { message ->
            appViewModel.userInput.value = message.toString()
        }

        binding.passwordEditText.doAfterTextChanged { message ->
            appViewModel.passwordInput.value = message.toString()
        }

        binding.confirmEditText.doAfterTextChanged { message ->
            appViewModel.confirmPassword.value = message.toString()
        }

        setupObservers()
        return binding.root
    }

    private fun setupObservers(){
        messageObserver()
        errorObserver()
        missingObserver()
    }

    private fun messageObserver() {
        appViewModel.showRegisterMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "El usuario ha sido registrado", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowRegisterMessage()
            }
        })
    }

    private fun errorObserver() {
        appViewModel.showErrorMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "La contraseña debe ser igual", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowErrorMessage()
            }
        })
    }

    private fun missingObserver() {
        appViewModel.showMissingRegisterMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "Debe llenar todos los espacios", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowMissingRegisterMessage()
            }
        })
    }
}