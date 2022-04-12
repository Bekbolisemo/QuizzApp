package com.example.quizzapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import javax.annotation.Nullable

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

     lateinit var binding: VB

    abstract fun bind(): VB

    @Nullable
    @Override
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = bind()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter(view)

    }
    abstract fun initAdapter(view: View)
}