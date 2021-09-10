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
import com.nasser.appellas.databinding.FragmentLoginBinding
import com.nasser.appellas.ui.AppViewModel

class LoginFragment: Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }

        binding.userInputText.doAfterTextChanged { message ->
            appViewModel.userLoginInput.value = message.toString()
        }

        binding.passwordInputText.doAfterTextChanged { message ->
            appViewModel.passwordLoginInput.value = message.toString()
        }

        setupObservers()
        return binding.root
    }

    private fun setupObservers() {
        loginObserver()
        errorLoginObserver()
    }

    private fun loginObserver() {
        appViewModel.showLoginMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowLoginMessage()
            }
        })
    }

    private fun errorLoginObserver() {
        appViewModel.showErrorLoginMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "Contraseña incorrecta", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowErrorLoginMessage()
            }
        })
    }
}