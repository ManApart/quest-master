package gameData

import kotlinx.serialization.Serializable

@Serializable
data class Blueprint(
    val Version: String,
    val Name: String? = null,
    val Thumbnail: String? = null,
    val Size: Coordinates,
    val Entities: List<Entity>,
    val Tilemaps: TileMap,
)

@Serializable
data class Coordinates(val X: Float, val Y: Float)

@Serializable
data class Bounds(val Position: Coordinates, val Size: Coordinates)

@Serializable
data class Entity(
    val Entity: String,
    val Position: Coordinates,
    val Condition: String? = null,
    val Group: String? = null,
    val Attachment: String? = null,
    val Inversion: String? = null,
    val Projectile: String? = null,
    val Rotation: Float? = null,
    val Speed: String? = null,
)

@Serializable
data class TileMap(
    val Palette: List<String>,
    val Rooms: List<Room>,
    val Offset: Coordinates,
)

@Serializable
data class Room(
    val Bounds: Bounds,
    val Tilemaps: MutableMap<String, String>
)
