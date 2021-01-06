package com.emptycoder.apiassignment.ui.all

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.emptycoder.apiassignment.R
import com.emptycoder.apiassignment.adapter.RcAdapter
import com.emptycoder.apiassignment.databinding.FragmentAllBinding
import com.emptycoder.apiassignment.model.ArticlesItem

class AllFragment : Fragment() {
    lateinit var binding: FragmentAllBinding
    lateinit var rcAdapter: RcAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
       binding = FragmentAllBinding.inflate(layoutInflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(this).get(AllViewModel::class.java)
        rcAdapter = RcAdapter()
        viewModel.getNews()
        viewModel.setNews().observe(viewLifecycleOwner, Observer {
            rcAdapter.addNews(it.articles as ArrayList<ArticlesItem?>)
            binding.allRc.apply{
                layoutManager = LinearLayoutManager(context)
                adapter = rcAdapter
            }
        })


    }
}