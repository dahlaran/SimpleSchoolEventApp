package com.dahlaran.simpleschooleventapp.views.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dahlaran.simpleschooleventapp.databinding.CellEventBinding
import com.dahlaran.simpleschooleventapp.databinding.CellMonthEventBinding
import com.dahlaran.simpleschooleventapp.models.Event
import com.dahlaran.simpleschooleventapp.models.Item
import com.dahlaran.simpleschooleventapp.models.ItemType
import com.dahlaran.simpleschooleventapp.models.MonthEvent

class ItemListAdapter(val onclickItemCallback: (itemClicked: Event) -> Unit) :
    ListAdapter<Item, RecyclerView.ViewHolder>(ItemDiffUtils()) {

    class EventViewHolder(
        private val binding: CellEventBinding,
        val onclickCallback: ((itemClicked: Event) -> Unit)?
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                this.binding.event?.let { event ->
                    onclickCallback?.run {
                        this(event)
                    }
                }
            }
        }

        fun bind(event: Event) {
            binding.event = event
            binding.executePendingBindings()
        }
    }

    class MonthEventViewHolder(
        val binding: CellMonthEventBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(monthEvent: MonthEvent) {
            binding.eventMonth = monthEvent
            binding.executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type.ordinal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            ItemType.TYPE_EVENT.ordinal -> EventViewHolder(
                CellEventBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                ), onclickItemCallback
            )
            ItemType.TYPE_MONTH.ordinal -> MonthEventViewHolder(
                CellMonthEventBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            else -> throw IllegalStateException(
                "ViewType not supported, it must be a TYPE_EVENT ordinal to work"
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is EventViewHolder -> holder.bind(getItem(position).item as Event)
            is MonthEventViewHolder -> holder.bind(getItem(position).item as MonthEvent)
        }
    }

}
