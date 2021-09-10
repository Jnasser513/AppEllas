package com.nasser.appellas.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.nasser.appellas.R
import com.nasser.appellas.databinding.FragmentAdminAccountsBinding
import com.nasser.appellas.databinding.FragmentPerfilusuarioBinding
import com.nasser.appellas.databinding.FragmentPsicologoBinding
import com.nasser.appellas.ui.AppViewModel

class PerfilUsuarioFragment: Fragment() {

    private var _binding: FragmentPerfilusuarioBinding? = null
    private val binding get() = _binding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPerfilusuarioBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }

        binding.userInputText.doAfterTextChanged { message ->
            appViewModel.userProfileInput.value = message.toString()
        }

        binding.emailInputText.doAfterTextChanged { message ->
            appViewModel.emailProfileInput.value = message.toString()
        }

        binding.passwordInputText.doAfterTextChanged { message ->
            appViewModel.passwordProfileInput.value = message.toString()
        }

        setupObservers()
        return binding.root
    }

    private fun setupObservers() {
        missingObserver()
        deleteObserver()
        errorObserver()
    }

    private fun missingObserver() {
        appViewModel.showMissingProfileMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "Debe completar todos los campos", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowMissingProfileMessage()
            }
        })
    }

    private fun deleteObserver() {
        appViewModel.showDeleteMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "La cuenta ha sido eliminada!", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowDeleteMessage()
            }
        })
    }

    private fun errorObserver() {
        appViewModel.showErrorProfileMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "La contraseña o correo no coinciden!", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowErrorProfileMessage()
            }
        })
    }
}