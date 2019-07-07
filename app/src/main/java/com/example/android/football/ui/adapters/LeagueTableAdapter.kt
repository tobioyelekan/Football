package com.example.android.football.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.football.data.db.LeagueTable
import com.example.android.football.databinding.LeagueTableItemBinding

class LeagueTableAdapter() : ListAdapter<LeagueTable, LeagueTableAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LeagueTableItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val property = getItem(position)
        holder.bind(property, position)
    }

    class ViewHolder(private var binding: LeagueTableItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(leagueTable: LeagueTable, position: Int) {
            binding.position = position + 1
            binding.leagueTable = leagueTable
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<LeagueTable>() {
        override fun areItemsTheSame(oldItem: LeagueTable, newItem: LeagueTable): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: LeagueTable, newItem: LeagueTable): Boolean {
            return oldItem == newItem
        }
    }
}