package com.dahlaran.simpleschooleventapp.views.adapters

import androidx.recyclerview.widget.DiffUtil
import com.dahlaran.simpleschooleventapp.models.Event
import com.dahlaran.simpleschooleventapp.models.Item
import com.dahlaran.simpleschooleventapp.models.ItemType
import com.dahlaran.simpleschooleventapp.models.MonthEvent

class ItemDiffUtils : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        if (oldItem.type == newItem.type) {
            return when (oldItem.type) {
                ItemType.TYPE_EVENT -> (oldItem.item as Event).toString() == (newItem.item as Event).toString()
                ItemType.TYPE_MONTH -> (oldItem.item as MonthEvent).toString() == (newItem.item as MonthEvent).toString()
            }
        }
        return false
    }
}