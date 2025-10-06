package dev.thundercloud.galacticmerchants.model.serverstatus

import kotlinx.serialization.Serializable

@Serializable
data class MostSubmittedChartsItem(val chartCount: Int = 0,
                                   val agentSymbol: String = "")