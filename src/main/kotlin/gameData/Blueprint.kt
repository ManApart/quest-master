
package gameData

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlin.io.encoding.Base64
import kotlin.io.encoding.ExperimentalEncodingApi

@Serializable
data class Blueprint(
    val Version: String,
    val Thumbnail: String? = null,
    val Size: Coordinates,
    val Entities: List<Entity>,
    val Tilemaps: TileMap,
    val Name: String? = null,
)

@Serializable
data class Coordinates(val X: Int, val Y: Int)

@Serializable
data class PreciseCoordinates(val X: Float, val Y: Float)

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

@OptIn(ExperimentalEncodingApi::class)
@Serializable
data class Room(
    val Bounds: Bounds,
    private var Tilemaps: Map<String, String>
) {
    //key: guid of respective tilemap layer
    //value: array that points into the tile palette
    @Transient
    val tileMap = mutableMapOf<String, MutableList<Int>>()
    init {
        Tilemaps.entries.forEach { (layer, rawData) ->
            tileMap[layer] = Base64.decode(rawData).map { it.toInt() }.toMutableList()
        }
    }
    fun updateTileMaps(){
        Tilemaps = tileMap.entries.associate { (layer, data) -> layer to Base64.encode(data.map{it.toByte()}.toByteArray()) }
    }
}
