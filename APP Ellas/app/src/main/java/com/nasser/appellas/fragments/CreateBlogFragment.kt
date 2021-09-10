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
import com.nasser.appellas.databinding.FragmentCreateBlogBinding
import com.nasser.appellas.ui.AppViewModel

class CreateBlogFragment: Fragment() {

    private var _binding: FragmentCreateBlogBinding? = null
    private val binding get() = _binding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateBlogBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }

        binding.tittleInputText.doAfterTextChanged { message ->
            appViewModel.tittleInput.value = message.toString()
        }

        binding.subtittleInputText.doAfterTextChanged { message ->
            appViewModel.subtittleInput.value = message.toString()
        }

        binding.descriptionInputText.doAfterTextChanged { message ->
            appViewModel.descriptionInput.value = message.toString()
        }

        setupObservers()
        return binding.root
    }

    private fun setupObservers() {
        missingObserver()
        createObserver()
    }

    private fun missingObserver() {
        appViewModel.showMissingBlogMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "Debe llenar todos los espacios", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowMissingBlogMessage()
            }
        })
    }

    private fun createObserver() {
        appViewModel.showCreateBlogMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if(it){
                    Toast.makeText(requireContext(), "¡Gracias por compartir tu historia!", Toast.LENGTH_SHORT).show()
                }
                appViewModel.endShowCreateBlogMessage()
            }
        })
    }

}