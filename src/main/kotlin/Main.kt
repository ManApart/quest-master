import gameData.Blueprint
import kotlinx.serialization.encodeToString
import java.io.File

val jsonMapper = kotlinx.serialization.json.Json {
    ignoreUnknownKeys = true
    encodeDefaults = false
    prettyPrint = true
}

fun main() {
    File("./input").listFiles()!!
        .filter { it.name.contains("c532d476-0eaa-409f-ba2b-d4c35ac21428") }
        .map { it.name to jsonMapper.decodeFromString<Blueprint>(it.readText()) }
        .map { (name, data) -> name to data.transform() }
        .map { (name, data) -> name to jsonMapper.encodeToString(data) }
        .forEach { (name, data) -> File("./output/$name").writeText(data) }
}

private fun Blueprint.transform(): Blueprint {
    println("$Name ${Tilemaps.Rooms.first().tileMap}")
    return rotate90()
}
