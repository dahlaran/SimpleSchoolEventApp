package com.dahlaran.simpleschooleventapp.models

data class Event(
    val address: Address,
    val appIds: String,
    val categories: List<Category>,
    val content: String,
    val createdAt: String,
    val createdBy: String,
    val dateEnd: String,
    val dateStart: String,
    val editor_access: Boolean,
    val form: String,
    val id: String,
    val linksToItem: List<Any>,
    val medias: List<Any>,
    val name: String,
    val owner: String,
    val parentsFixedAt: String,
    val payload: Payload,
    val payload_schema: String,
    val publishState: String,
    val slug: String,
    val title: String,
    val type: String,
    val updatedAt: String
)

