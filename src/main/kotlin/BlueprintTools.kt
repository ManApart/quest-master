import gameData.Blueprint

fun Blueprint.rotate90(): Blueprint {
    Tilemaps.Rooms.forEach { room ->
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
