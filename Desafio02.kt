fun main() {
    val transportTypes = arrayOf("Carro", "Ônibus", "Avião")
    val emissionFactors = arrayOf(0.21, 0.105, 0.133) // Fatores de emissão em kg CO2/km
    val distances = mutableListOf<Double>()
    val transports = mutableListOf<Int>()

    while (true) {
        println("Digite a distância percorrida em km (ou 'sair' para finalizar):")
        val distanceInput = readLine()
        if (distanceInput == "sair") break
        val distance = distanceInput?.toDoubleOrNull()
        if (distance == null || distance <= 0) {
            println("Entrada inválida, por favor, digite uma distância válida.")
            continue
        }

        println("Digite o meio de transporte (Carro, Ônibus, Avião):")
        val transportInput = readLine()
        val transportIndex = transportTypes.indexOf(transportInput)
        if (transportIndex == -1) {
            println("Transporte inválido, por favor, escolha entre Carro, Ônibus ou Avião.")
            continue
        }

        distances.add(distance)
        transports.add(transportIndex)
    }

    val carbonFootprints = distances.mapIndexed { index, distance ->
        distance * emissionFactors[transports[index]]
    }

    val totalCarbonFootprint = carbonFootprints.sum()

    carbonFootprints.forEachIndexed { index, footprint ->
        println("Pegada de CO2 para a viagem ${index + 1}: ${footprint} kg")
    }

    println("Pegada total de CO2: $totalCarbonFootprint kg")
}
