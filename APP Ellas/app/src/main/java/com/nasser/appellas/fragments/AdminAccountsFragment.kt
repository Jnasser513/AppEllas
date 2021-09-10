package com.nasser.appellas.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nasser.appellas.data.entity.User
import com.nasser.appellas.databinding.FragmentAdminAccountsBinding
import com.nasser.appellas.ui.AppViewModel
import com.nasser.appellas.ui.BlogAdapter
import com.nasser.appellas.ui.UserAdapter

class AdminAccountsFragment : Fragment() {

    private var _binding: FragmentAdminAccountsBinding? = null
    private val binding get() = _binding!!

    private val appViewModel: AppViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val userAdapter = UserAdapter {
            appViewModel.deleteUser(it)
        }
        _binding = FragmentAdminAccountsBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = appViewModel
                lifecycleOwner = viewLifecycleOwner
            }

        var rv = binding.userRecyclerview.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        appViewModel.userList.observe(viewLifecycleOwner) {
            userAdapter.setData(it)
        }

        return binding.root
    }
}