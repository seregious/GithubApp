package com.example.githubtestapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubtestapp.R
import com.example.githubtestapp.databinding.FragmentAuthBinding
import com.example.githubtestapp.databinding.FragmentListBinding


class AuthFragment : Fragment() {

    private lateinit var binding: FragmentAuthBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAuthBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButton()
    }

    private fun setupButton() {
        binding.button.setOnClickListener {
            setupFragment()
        }
    }

    private fun setupFragment() {
        parentFragmentManager.beginTransaction().replace(R.id.fragmentContainer, ListFragment()).commit()
    }
}