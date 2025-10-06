package dev.thundercloud.galacticmerchants.model.serverstatus

import kotlinx.serialization.Serializable

@Serializable
data class ServerStatus(
    val serverResets: ServerResets,
    val resetDate: String = "",
    val stats: Stats,
    val description: String = "",
    val health: Health,
    val links: List<LinksItem>?,
    val leaderboards: Leaderboards,
    val version: String = "",
    val announcements: List<AnnouncementsItem>?,
    val status: String = ""
)