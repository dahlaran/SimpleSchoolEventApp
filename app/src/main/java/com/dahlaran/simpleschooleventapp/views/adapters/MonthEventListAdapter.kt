package com.dahlaran.simpleschooleventapp.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dahlaran.simpleschooleventapp.R
import com.dahlaran.simpleschooleventapp.databinding.CellMonthEventBinding
import com.dahlaran.simpleschooleventapp.models.Event
import com.dahlaran.simpleschooleventapp.models.MonthEvent

class MonthEventListAdapter(val onclickItemCallback: (itemClicked: Event) -> Unit) :
    ListAdapter<MonthEvent, MonthEventListAdapter.MonthEventViewHolder>(MonthEventDiffUtils()) {

    class MonthEventViewHolder(
        val binding: CellMonthEventBinding,
        val onclickItemCallback: ((itemClicked: Event) -> Unit)
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            val listAdapter = EventListAdapter(onclickItemCallback)

            binding.eventRecycler.apply {
                adapter = listAdapter
                layoutManager = LinearLayoutManager(context)
                val decorator = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
                decorator.setDrawable(getDrawable(context, R.drawable.event_divider)!!)
                addItemDecoration(decorator)
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
        return MonthEventViewHolder(binding, onclickItemCallback)
    }

    override fun onBindViewHolder(holder: MonthEventViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}