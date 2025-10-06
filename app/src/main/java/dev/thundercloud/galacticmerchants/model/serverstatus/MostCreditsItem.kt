package dev.thundercloud.galacticmerchants.model.serverstatus

import kotlinx.serialization.Serializable

@Serializable
data class MostCreditsItem(val credits: Int = 0,
                           val agentSymbol: String = "")