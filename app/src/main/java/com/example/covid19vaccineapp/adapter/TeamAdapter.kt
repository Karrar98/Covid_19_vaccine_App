package com.example.covid19vaccineapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19vaccineapp.R
import com.example.covid19vaccineapp.databinding.ItemTeamBinding
import com.example.covid19vaccineapp.model.Team

class TeamAdapter(private val listTeam: MutableList<Team>): RecyclerView.Adapter<TeamAdapter.TeamViewHolder>(){

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val currentTeam = listTeam[position]
        holder.binding.apply {
            txtNameTeam.text = currentTeam.name
            txtTypeTeam.text = currentTeam.type
            imgTeam.setImageDrawable(ContextCompat.getDrawable(context, currentTeam.image))
        }
    }

    override fun getItemCount() = listTeam.size

    class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemTeamBinding.bind(itemView)
    }
}