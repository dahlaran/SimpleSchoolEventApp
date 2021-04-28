package com.dahlaran.simpleschooleventapp.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.dahlaran.simpleschooleventapp.databinding.ActivityMainBinding
import com.dahlaran.simpleschooleventapp.viewmodels.EventListViewModel
import com.dahlaran.simpleschooleventapp.views.ExtraConst.EXTRA_EVENT_ID
import com.dahlaran.simpleschooleventapp.views.adapters.MonthEventListAdapter

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val eventListViewModel: EventListViewModel by viewModels<EventListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.apply {
            this.viewModel = eventListViewModel
            this.lifecycleOwner = this@MainActivity
        }

        setUpListAdapter()

        setContentView(binding.root)
    }

    private fun setUpListAdapter() {
        val listAdapter = MonthEventListAdapter{
            getToDescriptionActivity(it.id)
        }

        binding.monthEventRecycler.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun getToDescriptionActivity(eventId: String){
        val intent = Intent(this, EventDescriptionActivity::class.java).apply {
            putExtra(EXTRA_EVENT_ID, eventId)
        }
        startActivity(intent)
    }
}