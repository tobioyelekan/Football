package com.example.android.football.ui.fragments

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.android.football.databinding.LeagueTableFragmentBinding
import com.example.android.football.ui.activities.CompetitionDetail
import com.example.android.football.ui.adapters.LeagueTableAdapter
import com.example.android.football.ui.viewmodels.LeagueTableViewModel

class LeagueTableFragment : Fragment() {

    companion object {
        private const val ARG_COMPETITION_ID = "competition_id"

        fun newInstance(competitionId: Int): LeagueTableFragment {
            val fragment = LeagueTableFragment()
            val args = Bundle()
            args.putInt(ARG_COMPETITION_ID, competitionId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = LeagueTableFragmentBinding.inflate(inflater)

        val application = requireNotNull(this.activity).application
        val competitionId = arguments?.getInt(ARG_COMPETITION_ID)

        val factory = ViewModelFactory(competitionId!!, application)
        val viewModel = ViewModelProviders.of(this, factory).get(LeagueTableViewModel::class.java)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        val adapter = LeagueTableAdapter()

        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.getContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        binding.recyclerView.adapter = adapter

        viewModel.tables.observe(this, Observer {
            adapter.submitList(it)
        })

        return binding.root
    }
}

class ViewModelFactory(private val competitionId: Int, private val application: Application) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LeagueTableViewModel::class.java)) {
            return LeagueTableViewModel(competitionId, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}