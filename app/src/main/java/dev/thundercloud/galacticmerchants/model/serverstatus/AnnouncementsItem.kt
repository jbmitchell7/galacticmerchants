package dev.thundercloud.galacticmerchants.model.serverstatus

import kotlinx.serialization.Serializable

@Serializable
data class AnnouncementsItem(
    val title: String = "",
    val body: String = ""
)