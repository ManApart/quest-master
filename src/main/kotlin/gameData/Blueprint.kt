package gameData

import kotlinx.serialization.Serializable

@Serializable
data class Blueprint(
    val Version: String,
    val Size: Size
)

@Serializable
data class Size(val X: Int, val Y: Int)
