package com.dahlaran.simpleschooleventapp.models

class Item(val item : Any, val type: ItemType) {

}

enum class ItemType(val type: String) {
    TYPE_EVENT("Event"), TYPE_MONTH("Month")
}