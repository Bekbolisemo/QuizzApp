package com.example.quizzapp.presentation.thirdfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizzapp.R
import com.example.quizzapp.base.BaseFragment
import com.example.quizzapp.databinding.FragmentThirdBinding

class ThirdFragment : BaseFragment<FragmentThirdBinding>() {
    override fun bind(): FragmentThirdBinding {
        return FragmentThirdBinding.inflate(layoutInflater)
    }

    override fun initAdapter(view: View) {

    }

}