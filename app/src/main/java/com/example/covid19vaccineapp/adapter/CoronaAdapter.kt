package com.example.covid19vaccineapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.ItemCoronaBinding

class CoronaAdapter(private val listTitle: List<String>, private val listImage: List<Int>) :
    RecyclerView.Adapter<CoronaAdapter.CoronaHolderView>() {

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoronaHolderView {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_corona, parent, false)
        return CoronaHolderView(view)
    }

    override fun onBindViewHolder(holder: CoronaHolderView, position: Int) {
        val currentTitle = listTitle[position]
        val currentImage = listImage[position]
        holder.binding.apply {
            imgCorona.setImageDrawable(ContextCompat.getDrawable(context, currentImage))
            txtTitle.text = currentTitle
        }

    }

    override fun getItemCount() = listTitle.size

    class CoronaHolderView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemCoronaBinding.bind(itemView)
    }
}