package com.dahlaran.simpleschooleventapp.views.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dahlaran.simpleschooleventapp.R
import com.dahlaran.simpleschooleventapp.databinding.ActivityMainBinding
import com.dahlaran.simpleschooleventapp.viewmodels.EventListViewModel
import com.dahlaran.simpleschooleventapp.views.ExtraConst.EXTRA_EVENT_ID
import com.dahlaran.simpleschooleventapp.views.adapters.ItemListAdapter

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
        val listAdapter = ItemListAdapter {
            getToDescriptionActivity(it.id)
        }

        binding.itemListRecycler.apply {
            adapter = listAdapter
            layoutManager = LinearLayoutManager(context)
            val decorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            decorator.setDrawable(
                AppCompatResources.getDrawable(
                    context,
                    R.drawable.event_divider
                )!!
            )
            addItemDecoration(decorator)
        }
    }

    private fun getToDescriptionActivity(eventId: String) {
        val intent = Intent(this, EventDescriptionActivity::class.java).apply {
            putExtra(EXTRA_EVENT_ID, eventId)
        }
        startActivity(intent)
    }
}