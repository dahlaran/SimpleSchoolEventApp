package com.dahlaran.simpleschooleventapp.views.extensions

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dahlaran.simpleschooleventapp.models.Event
import com.dahlaran.simpleschooleventapp.models.Item
import com.dahlaran.simpleschooleventapp.models.MonthEvent
import com.dahlaran.simpleschooleventapp.views.adapters.ItemListAdapter

@BindingAdapter("app:items")
fun setItemsList(listView: RecyclerView, itemList: List<Any>?) {
    itemList?.let {
        when (listView.adapter) {
            is ItemListAdapter -> (listView.adapter as ItemListAdapter).submitList(it as List<Item>)
        }
    }
}