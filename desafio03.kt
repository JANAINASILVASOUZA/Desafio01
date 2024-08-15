import java.io.File
import java.io.IOException

fun main() {
    val emissionFactors = mapOf(
        "Arroz" to 0.001,
        "Feijão" to 0.002,
        "Carne" to 0.014
    )

    var totalCarbonFootprint = 0.0

    try {
        val file = File("itens.txt")
        file.forEachLine { line ->
            val parts = line.split(":")
            val item = parts.getOrNull(0)?.trim()
            val quantity = parts.getOrNull(1)?.trim()?.removeSuffix("g")?.toDoubleOrNull()

            val carbonFootprint = item?.let { itemName ->
                val factor = emissionFactors[itemName] ?: 0.0
                (quantity ?: 0.0) * factor
            } ?: 0.0

            totalCarbonFootprint += carbonFootprint
        }

        println("Pegada total de CO2: $totalCarbonFootprint kg")
    } catch (e: IOException) {
        println("Erro ao ler o arquivo: ${e.message}")
    } catch (e: Exception) {
        println("Erro no formato dos dados: ${e.message}")
    }
}
