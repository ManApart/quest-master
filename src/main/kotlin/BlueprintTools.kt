import gameData.Blueprint
import gameData.print
import gameData.toTile

fun Blueprint.rotate90(): Blueprint {
    Size.flip()
    Tilemaps.Rooms.forEach { room ->
//        room.tileMap.shift(room.Bounds.Size.X)
        room.Bounds.Size.flip()
        room.updateTileMaps()
    }
    return this
}
fun Blueprint.rotate180(): Blueprint {
    return this
}
fun Blueprint.rotate270(): Blueprint {
    return this
}
fun Blueprint.mirrorVertical(): Blueprint {
    return this
}
fun Blueprint.mirrorHorizontal(): Blueprint {
    return this
}

private fun MutableMap<String, MutableList<Int>>.shift(amount: Int){
    entries.forEach { (layer, data) ->
        val shiftedData = data.subList(amount, data.lastIndex) + data.subList(0, amount)
        this[layer] = shiftedData.toMutableList()
    }
}

fun Blueprint.print() {
    val palette = Tilemaps.Palette.map { it.toTile() }
    val roomText = Tilemaps.Rooms.joinToString { it.tileMap.print(palette) }
    println("$Name $Size $palette  $roomText")
}
