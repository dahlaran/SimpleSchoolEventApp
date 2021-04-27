package com.dahlaran.simpleschooleventapp.views.adapters

import androidx.recyclerview.widget.DiffUtil
import com.dahlaran.simpleschooleventapp.models.MonthEvent

class MonthEventDiffUtils: DiffUtil.ItemCallback<MonthEvent>() {
    override fun areItemsTheSame(oldItem: MonthEvent, newItem: MonthEvent): Boolean {
        return (oldItem.month == newItem.month && oldItem.year == newItem.year)
    }

    override fun areContentsTheSame(oldItem: MonthEvent, newItem: MonthEvent): Boolean {
        return oldItem == newItem
    }
}