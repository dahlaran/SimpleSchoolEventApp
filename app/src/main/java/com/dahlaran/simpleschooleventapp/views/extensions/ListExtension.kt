package com.dahlaran.simpleschooleventapp.views.extensions

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dahlaran.simpleschooleventapp.models.Event
import com.dahlaran.simpleschooleventapp.models.MonthEvent
import com.dahlaran.simpleschooleventapp.views.adapters.EventListAdapter
import com.dahlaran.simpleschooleventapp.views.adapters.MonthEventListAdapter

@BindingAdapter("app:items")
fun setItemsList(listView: RecyclerView, itemList: List<Any>?) {
    itemList?.let {
        when (listView.adapter) {
            is EventListAdapter -> (listView.adapter as EventListAdapter).submitList(it as List<Event>)
            is MonthEventListAdapter -> (listView.adapter as MonthEventListAdapter).submitList(it as List<MonthEvent>)
        }
    }
}