package com.example.ec3choquenelson.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ec3choquenelson.R
import com.example.ec3choquenelson.databinding.FragmentInfoBinding
import com.example.ec3choquenelson.databinding.FragmentListBinding
import com.example.ec3choquenelson.model.getData


class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[HomeViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListBinding.inflate(inflater,container,false);


        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RVMealAdapter(listOf())


        binding.rcvMeals.adapter = adapter
        binding.rcvMeals.layoutManager = GridLayoutManager(requireContext(),2,RecyclerView.VERTICAL,false)

        viewModel.meals.observe(requireActivity()){meal ->
            adapter.meals = meal
            adapter.notifyDataSetChanged()
        }

        viewModel.getMealService()

    }


}