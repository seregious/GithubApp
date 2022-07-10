package com.example.githubtestapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.githubtestapp.R
import com.example.githubtestapp.data.Constants
import com.example.githubtestapp.databinding.FragmentListBinding
import com.example.githubtestapp.domain.Rep


class ListFragment : Fragment(), RepAdapter.Listener {

    private lateinit var binding: FragmentListBinding
    private lateinit var adapter: RepAdapter
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        (activity as AppCompatActivity).supportActionBar?.title =Constants.REPS_BAR_TITLE
    }

    private fun setupAdapter() {
        viewModel.getRepList()
        adapter = RepAdapter(this)
        binding.repList.adapter = adapter
        viewModel.repList.observe(viewLifecycleOwner) {
            adapter.repList = it
        }
    }

    override fun onClick(rep: Rep) {
        setupFragment()
        viewModel.selectedRep.value = rep
    }

    private fun setupFragment() {
        parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer, InfoFragment()).commit()
    }
}