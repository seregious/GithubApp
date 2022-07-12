package com.example.githubtestapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import com.example.githubtestapp.databinding.FragmentInfoBinding
import java.util.*


class InfoFragment : Fragment() {

    private lateinit var binding: FragmentInfoBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
        //setupReadme()
    }

    private fun setupData() = with(binding) {
        val rep = viewModel.selectedRep.value
        if (rep != null) {
            (activity as AppCompatActivity).supportActionBar?.title = rep.name
            repForks.text = rep.forks.toString() + " forks"
            repLicense2.text = rep.license
            repStars.text = rep.stargazers_count.toString() + " stars"
            repLink.text = rep.svn_url
            repWatchers.text = rep.watchers_count.toString() + " watchers"
            repReadme.text = "readme"

            if (rep.license == null) {
                repLicense.visibility = View.GONE
                repLicense2.visibility = View.GONE
            }
        }
    }

    private fun setupReadme() {
        viewModel.getReadme()
        val text = viewModel.readMe.value.toString()
        val decodedBytes: ByteArray = Base64.getDecoder().decode(text)
        binding.repReadme.text = decodedBytes.toString()
    }
}