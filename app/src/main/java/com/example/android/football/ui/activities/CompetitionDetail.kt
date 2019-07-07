package com.example.android.football.ui.activities

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.android.football.R
import com.example.android.football.ui.fragments.LeagueTableFragment
import kotlinx.android.synthetic.main.activity_competition_detail.*
import kotlinx.android.synthetic.main.fragment_competition_detail.view.*

class CompetitionDetail : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_competition_detail)
        setSupportActionBar(toolbar)

        val competitionName = intent.getStringExtra("competition_name")
        val competitionId = intent.getIntExtra("competition_id", 0)

        supportActionBar?.title = competitionName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, competitionId)
        viewpager.adapter = mSectionsPagerAdapter
        tab.setupWithViewPager(viewpager)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> super.onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    inner class SectionsPagerAdapter(
        fm: FragmentManager,
        private val competition_id: Int
    ) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment? {
            when (position) {
                0 -> return LeagueTableFragment.newInstance(competition_id)
                1 -> return PlaceholderFragment.newInstance(getString(R.string.fixtures_not_available))
                2 -> return PlaceholderFragment.newInstance(getString(R.string.team_status))
            }
            return null
        }

        override fun getCount(): Int {
            return 3
        }

        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return getString(R.string.tab_table_label)
                1 -> return getString(R.string.tab_fixtures_label)
                2 -> return getString(R.string.tab_label_teams)
            }
            return null
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val rootView = inflater.inflate(R.layout.fragment_competition_detail, container, false)
            rootView.section_label.text = arguments?.getString(ARG_SECTION_TEXT)
            return rootView
        }

        companion object {

            private val ARG_SECTION_TEXT = "section_text"

            fun newInstance(sectionText: String): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putString(ARG_SECTION_TEXT, sectionText)
                fragment.arguments = args
                return fragment
            }
        }
    }
}
