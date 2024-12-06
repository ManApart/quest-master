package gameData

enum class Layer(val guid: String) {
    L1("1620ca16711a0d64ebf397fd49b5f270"),
    L2("1997fb9fdd5744626862935ccde4d6e1"),
    L3("0bb86156bf6e0974895328acafc4161c"),
    WEB("dd8091b6a6aee3b4992ed33e2882c652"),
    L5("6a80f4262edfb4e4e8d5bbdb1768f966"),
    L6("9e0a8dcd17a1a42a08ce84bdf8552937"),
    DIRT("9f5a235f083938145bf1a286d3f33562"),
    UNKNOWN(""),
}

fun String.toLayer(): Layer {
    return Layer.entries.firstOrNull { it.guid == this } ?: Layer.UNKNOWN
}

enum class Tile(val guid: String) {
    GRASS("a46de763ba3577f4780ebe4aa8080252"),
    THORN("bced8eafa5a0a43389bcf215f9d4ab98"),
    FENCE("a4ab6864420e26f4b9aa250b9a1808a0"),
    WEB("db13e06a37dd249439085a6711b11b42"),
    WATER_SHALLOW("47a48387e886c7a488f9cb2e623caa0c"),
    CRACKED_DIRT("a3a21fb47932ce149b0790cd2de5739c"),
    HOLE("4d6a8fc4a1b8b794992e5a124085b0d2"),
    WATER("ca4576136ee31754680859009b86e8b6"),
    LAVA("cd565fe37b4c7e54aa3d3d2b16c5e2ce"),
    MUD("0b88f418d5ce54ec887152807e33fb48"),
    DIRT("3b6d8ed1f2a39064e933b3ec73a6eb41"),
    UNKNOWN(""),
}

fun String.toTile(): Tile {
    return Tile.entries.firstOrNull { it.guid == this } ?: Tile.UNKNOWN
}

fun Map<String, List<Int>>.print(palette: List<Tile>): String {
    return "{" + entries.joinToString { (layer, ids) ->
        val layerName = layer.toLayer()
        val idMap = ids.joinToString { if (it == -1) "" else palette[it].toString() }
        "$layerName=[$idMap]"
    } + "}"
}
