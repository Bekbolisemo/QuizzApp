package com.example.quizzapp.presentation.secondfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quizzapp.R
import com.example.quizzapp.base.BaseFragment
import com.example.quizzapp.databinding.FragmentSecondBinding


class SecondFragment : BaseFragment<FragmentSecondBinding>() {
    override fun bind(): FragmentSecondBinding {
        return FragmentSecondBinding.inflate(layoutInflater)
    }

    override fun initAdapter(view: View) {
    }
}