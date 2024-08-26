class Llamada(val tipoLlamada: String, var duracion: Float, val cabina: Int) {
    private val valorLlamada: Float = when (tipoLlamada) {
        "local" -> 50f
        "internacional" -> 350f
        "celular" -> 150f
        else -> throw IllegalArgumentException("Tipo de llamada no válido")
    }

    // Método para calcular el valor de la llamada en función de su duración
    fun calcularValor(): Float {
        return duracion * valorLlamada
    }
}
