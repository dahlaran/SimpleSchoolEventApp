package com.dahlaran.simpleschooleventapp.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dahlaran.simpleschooleventapp.databinding.CellMonthEventBinding
import com.dahlaran.simpleschooleventapp.models.MonthEvent

class MonthEventListAdapter :
    ListAdapter<MonthEvent, MonthEventListAdapter.MonthEventViewHolder>(MonthEventDiffUtils()) {

    class MonthEventViewHolder(val binding: CellMonthEventBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            val listAdapter = EventListAdapter()

            binding.eventRecycler.apply {
                adapter = listAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }

        fun bind(monthEvent: MonthEvent) {
            binding.eventMonth = monthEvent

            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthEventViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CellMonthEventBinding.inflate(layoutInflater, parent, false)
        return MonthEventViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MonthEventViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}