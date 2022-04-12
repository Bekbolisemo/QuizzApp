package com.example.quizzapp.presentation.mainfragment

import android.annotation.SuppressLint
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.quizzapp.R
import com.example.quizzapp.base.BaseFragment
import com.example.quizzapp.databinding.FragmentMainBinding
import com.google.android.material.slider.Slider

class MainFragment : BaseFragment<FragmentMainBinding>() {
    override fun bind(): FragmentMainBinding {
        return  FragmentMainBinding.inflate(layoutInflater)
    }

    override fun initAdapter(view: View) {

        val spinnerCategory: Spinner = binding.spinnerCategory
        val spinnerDifficulty: Spinner = binding.spinnerDifficulty

        ArrayAdapter.createFromResource(
            view.context,
            R.array.array_spinner_category,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            spinnerCategory.adapter = adapter

        }
        ArrayAdapter.createFromResource(
            view.context,
            R.array.array_spinner_Difficulty,
            android.R.layout.simple_spinner_item
        ).also { adapter->
            adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
            spinnerDifficulty.adapter = adapter
        }
        binding.sliderView.addOnSliderTouchListener(object :Slider.OnSliderTouchListener{
            @SuppressLint("RestrictedApi")
            override fun onStartTrackingTouch(slider: Slider) {
            }

            @SuppressLint("RestrictedApi")
            override fun onStopTrackingTouch(slider: Slider) {
                binding.amountNumberView.text = slider.value.toInt().toString()
            }

        })
    }


}