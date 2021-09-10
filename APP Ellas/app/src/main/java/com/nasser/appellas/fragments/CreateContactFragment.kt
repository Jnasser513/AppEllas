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
import com.nasser.appellas.databinding.FragmentCreateContactBinding
import com.nasser.appellas.databinding.FragmentMapainformativoBinding
import com.nasser.appellas.ui.AppViewModel

class CreateContactFragment: Fragment() {

    private var _binding: FragmentCreateContactBinding? = null
    private val binding get() = _binding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateContactBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }

        binding.contactNameInputText.doAfterTextChanged { message ->
            appViewModel.contactNameInput.value = message.toString()
        }

        binding.contactNumberInputText.doAfterTextChanged { message ->
            appViewModel.numberContactInput.value = message.toString()
        }

        setupObservers()
        return binding.root
    }

    private fun setupObservers() {
        missingObserver()
        createObserver()
    }

    private fun missingObserver() {
        appViewModel.showMissingContactMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "Llene todos los campos", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowMissingContactMessage()
            }
        })
    }

    private fun createObserver() {
        appViewModel.showContactMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "El contacto ha sido añadido", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowContactMessage()
            }
        })
    }
}