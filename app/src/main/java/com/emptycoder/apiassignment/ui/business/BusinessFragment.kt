package com.emptycoder.apiassignment.ui.business

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.emptycoder.apiassignment.R

class BusinessFragment : Fragment() {

    private lateinit var businessViewModel: BusinessViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        businessViewModel =
                ViewModelProvider(this).get(BusinessViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_business, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        businessViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}