package dev.thundercloud.galacticmerchants.model.serverstatus

import kotlinx.serialization.Serializable

@Serializable
data class Stats(val ships: Int = 0,
                 val systems: Int = 0,
                 val accounts: Int = 0,
                 val waypoints: Int = 0,
                 val agents: Int = 0)