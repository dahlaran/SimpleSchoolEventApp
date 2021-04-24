package com.dahlaran.simpleschooleventapp.views.adapters

import androidx.recyclerview.widget.DiffUtil
import com.dahlaran.simpleschooleventapp.models.Event

class EventDiffUtils : DiffUtil.ItemCallback<Event>() {
    override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
        return oldItem.toString() == newItem.toString()
    }

}
