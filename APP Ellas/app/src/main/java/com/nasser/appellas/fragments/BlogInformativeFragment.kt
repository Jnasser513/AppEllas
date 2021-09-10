package com.nasser.appellas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nasser.appellas.R
import com.nasser.appellas.data.entity.Blog
import com.nasser.appellas.databinding.FragmentAdminAccountsBinding
import com.nasser.appellas.databinding.FragmentInformativeBlogBinding
import com.nasser.appellas.ui.AppViewModel
import com.nasser.appellas.ui.BlogAdapter
import com.nasser.appellas.ui.UserAdapter

class BlogInformativeFragment: Fragment() {

    private var _binding: FragmentInformativeBlogBinding? = null
    private val binding get() = _binding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val blogAdapter = BlogAdapter()
        _binding = FragmentInformativeBlogBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }

        var rv = binding.blogRecyclerview.apply {
            adapter = blogAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        appViewModel.blogList.observe(viewLifecycleOwner) {
            blogAdapter.setData(it)
        }

        return binding.root
    }
}