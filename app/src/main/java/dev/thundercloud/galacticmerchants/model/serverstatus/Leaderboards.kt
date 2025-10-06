package dev.thundercloud.galacticmerchants.model.serverstatus

import kotlinx.serialization.Serializable

@Serializable
data class Leaderboards(val mostCredits: List<MostCreditsItem>?,
                        val mostSubmittedCharts: List<MostSubmittedChartsItem>?)