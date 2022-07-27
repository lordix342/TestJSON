package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.test.databinding.FragmentPersonBinding
import com.example.test.viewmodel.TestViewModel


class PersonFragment : Fragment() {
    private lateinit var binding: FragmentPersonBinding
    private val viewModel: TestViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPersonBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.personForDetail.observe(viewLifecycleOwner){
            with(binding){
                textNamePerson.text = it.name
                textGender.text = it.gender
                textAbout.text = it.about
                textDateBirth.text = it.birth.date
                Glide.with(requireContext()).load(it.picture).into(binding.imagePersonFoto)
            }
        }
    }

}