package com.dahlaran.simpleschooleventapp.views.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dahlaran.simpleschooleventapp.databinding.ActivityEventDescriptionBinding
import com.dahlaran.simpleschooleventapp.databinding.ActivityMainBinding
import com.dahlaran.simpleschooleventapp.viewmodels.EventViewModel
import com.dahlaran.simpleschooleventapp.views.ExtraConst

class EventDescriptionActivity : AppCompatActivity() {
    lateinit var binding: ActivityEventDescriptionBinding
    val eventViewModel: EventViewModel by viewModels<EventViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventDescriptionBinding.inflate(layoutInflater)

        binding.apply {
            this.viewModel = eventViewModel
            this.lifecycleOwner = this@EventDescriptionActivity
        }

        val eventId = intent.getStringExtra(ExtraConst.EXTRA_EVENT_ID)

        eventId?.let {
            eventViewModel.getEvent(it)
        } ?: Toast.makeText(this, "An error occured, Go Back", Toast.LENGTH_LONG).show()

        setContentView(binding.root)

        binding.backToolbar.setOnClickListener {
            onBackPressed()
        }

        setSupportActionBar(binding.toolbarDescription)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false)
    }
}
