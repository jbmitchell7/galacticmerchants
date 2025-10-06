package dev.thundercloud.galacticmerchants.model.serverstatus

import kotlinx.serialization.Serializable

@Serializable
data class LinksItem(val name: String = "",
                     val url: String = "")