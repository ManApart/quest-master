import gameData.Blueprint
import kotlinx.serialization.encodeToString
import java.io.File

val jsonMapper = kotlinx.serialization.json.Json {
    ignoreUnknownKeys = true
    encodeDefaults = false
}

fun main() {
    println("Test!")
    File("./input").listFiles()!!
        .map { it.name to jsonMapper.decodeFromString<Blueprint>(it.readText()) }
        .map { (name, data) -> name to data.transform() }
        .map { (name, data) -> name to jsonMapper.encodeToString(data) }
        .forEach { (name, data) -> File("./output/$name").writeText(data) }
}

private fun Blueprint.transform(): Blueprint {
    return this
}
