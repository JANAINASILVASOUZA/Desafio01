fun main() {

    // Consumo de energia
    val eletricidadeConsumo = 100.0 // kWh
    val gasConsumo = 50.0 // m³

    // Fatores de emissão
    val eletricidadeFator = 0.475 // kg CO2/kWh
    val gasFator = 2.0 // kg CO2/m³

    // Cálculo da pegada de carbono
    val eletricidadeCarbono = eletricidadeConsumo * eletricidadeFator
    val gasCarbono = gasConsumo * gasFator

    // Cálculo da pegada de carbono total
    val totalCarbono = eletricidadeCarbono + gasCarbono

    // Saída formatada
    println("Eletricidade: ${"%.2f".format(eletricidadeCarbono)} kg CO2")
    println("Gás: ${"%.2f".format(gasCarbono)} kg CO2")
    println("Total: ${"%.2f".format(totalCarbono)} kg CO2")
}