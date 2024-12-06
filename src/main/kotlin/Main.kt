import gameData.Blueprint
import kotlinx.serialization.encodeToString
import java.io.File

val jsonMapper = kotlinx.serialization.json.Json {
    ignoreUnknownKeys = true
    encodeDefaults = false
    prettyPrint = true
}

fun main() {
    val selected = listOf("TileLine")
//    val selected = listOf("FourSquare", "FourSquare 90", "FourSquare 180", "FourSquare 270")
    File("./input").listFiles()!!
        .filter { selected.isEmpty() || selected.contains(it.nameWithoutExtension) }
        .map { it.name to jsonMapper.decodeFromString<Blueprint>(it.readText()) }
        .map { (name, data) -> name to data.transform() }
        .map { (name, data) -> name to jsonMapper.encodeToString(data) }
        .forEach { (name, data) -> File("./output/$name").writeText(data) }
}

private fun Blueprint.transform(): Blueprint {
    print()
    return this
//    return rotate90().also { it.print() }
}
