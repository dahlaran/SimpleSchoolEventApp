package com.dahlaran.simpleschooleventapp.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dahlaran.simpleschooleventapp.databinding.CellEventBinding
import com.dahlaran.simpleschooleventapp.models.Event

class EventListAdapter : ListAdapter<Event, EventListAdapter.EventViewHolder>(EventDiffUtils()) {
    class EventViewHolder(private val binding: CellEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(event: Event) {
            binding.event = event
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CellEventBinding.inflate(layoutInflater, parent, false)
        return EventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
