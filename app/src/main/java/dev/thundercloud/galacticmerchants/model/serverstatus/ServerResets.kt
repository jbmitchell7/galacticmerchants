package dev.thundercloud.galacticmerchants.model.serverstatus

import kotlinx.serialization.Serializable

@Serializable
data class ServerResets(val next: String = "",
                        val frequency: String = "")