package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.databinding.FragmentListPersonBinding
import com.example.test.viewmodel.ClickListener
import com.example.test.model.ModelJSONItem
import com.example.test.viewmodel.RecyclerAdapter
import com.example.test.viewmodel.TestViewModel


class ListPersonFragment : Fragment(), ClickListener {
    private lateinit var binding: FragmentListPersonBinding
    private val viewModel: TestViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListPersonBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getList(requireContext().applicationContext)
        viewModel.arrayPersons.observe(viewLifecycleOwner){
            createRC(it)
        }
    }
    private fun createRC(persons: ArrayList<ModelJSONItem>){
        val adapter = RecyclerAdapter(this,requireContext())
        binding.rcView.adapter = adapter
        binding.rcView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setData(persons)
    }

    override fun onClick(person: ModelJSONItem) {
        Navigation.findNavController(binding.root).navigate(R.id.action_listPersonFragment_to_personFragment)
        viewModel.sendPerson(person)
    }
}