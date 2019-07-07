package com.example.android.football.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.football.data.db.Competition
import com.example.android.football.databinding.CompetitionItemBinding

class CompetitionAdapter(val callback: CompetitionClick) :
    ListAdapter<Competition, CompetitionAdapter.ViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CompetitionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val property = getItem(position)
        holder.bind(property, callback)
    }

    class ViewHolder(private var binding: CompetitionItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(transaction: Competition, callback: CompetitionClick) {
            binding.callback = callback
            binding.competition = transaction
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Competition>() {
        override fun areItemsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem == newItem
        }
    }
}

class CompetitionClick(val block: (Competition) -> Unit) {
    fun onClick(competition: Competition) = block(competition)
}