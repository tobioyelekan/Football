package com.example.android.football.ui.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.android.football.databinding.CompetitionFragmentBinding
import com.example.android.football.ui.adapters.CompetitionAdapter
import com.example.android.football.ui.viewmodels.CompetitionViewModel
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.android.football.data.db.Competition
import com.example.android.football.ui.activities.CompetitionDetail
import com.example.android.football.ui.adapters.CompetitionClick


class CompetitionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = CompetitionFragmentBinding.inflate(inflater)
        val viewModel = ViewModelProviders.of(this).get(CompetitionViewModel::class.java)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        val adapter = CompetitionAdapter(CompetitionClick {
            openNewActivity(it)
        })

        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )

        binding.recyclerView.adapter = adapter

        viewModel.competitions.observe(this, Observer {
            adapter.submitList(it)
        })
        return binding.root
    }

    private fun openNewActivity(competition: Competition) {

        startActivity(Intent(activity, CompetitionDetail::class.java).apply {
            putExtra("competition_id", competition.id)
            putExtra("competition_name", competition.name)
        })
    }

}
