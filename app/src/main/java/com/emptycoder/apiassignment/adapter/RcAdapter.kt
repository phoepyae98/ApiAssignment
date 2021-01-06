package com.emptycoder.apiassignment.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.emptycoder.apiassignment.databinding.FragmentAllBinding
import com.emptycoder.apiassignment.databinding.RcViewBinding
import com.emptycoder.apiassignment.model.ArticlesItem

class RcAdapter:RecyclerView.Adapter<RcAdapter.RcViewHolder>() {

    lateinit var news: ArrayList<ArticlesItem?>

    fun addNews(data: ArrayList<ArticlesItem?>){
        this.news = data
    }

    class RcViewHolder(val binding: RcViewBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(news: ArticlesItem?){
            binding.img.setImageResource(news!!.urlToImage!!.toInt())
            binding.tt.setText(news.title)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RcViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RcViewHolder(RcViewBinding.inflate(layoutInflater,parent,false))
    }

    override fun onBindViewHolder(holder: RcViewHolder, position: Int) {
        holder.bind(news[position])
    }

    override fun getItemCount() = news.size

}