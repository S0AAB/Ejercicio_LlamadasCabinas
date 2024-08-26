import kotlin.time.Duration
import kotlin.time.TimeSource

// Clase que representa una cabina telefónica
class Cabina(val numeroCabina: Int) {
    private val timeSource = TimeSource.Monotonic
    var registroLlamadas: MutableList<Llamada> = mutableListOf()

    // Método para realizar una llamada
    fun llamar() {
        limpiarConsola()
        var tipoLlamada = ""
        val entradaTeclado = imprimirMenuLlamada()

        // Determinar el tipo de llamada basado en la entrada del usuario
        when (entradaTeclado) {
            1 -> tipoLlamada = "local"
            2 -> tipoLlamada = "internacional"
            3 -> tipoLlamada = "celular"
            4 -> {
                limpiarConsola()
                imprimirMenuPrincipal()
                return
            }
            else -> {
                limpiarConsola()
                println("ERROR - OPCIÓN NO VÁLIDA.")
                return
            }
        }

        limpiarConsola()
        println("------------------------------")
        println("LLAMADA DE TIPO: $tipoLlamada")
        println("------------------------------")

        val marca1 = timeSource.markNow()

        // Bucle para simular una llamada en curso
        while (true) {
            println("En curso . . .\n\n1. Terminar llamada")
            val teclado = try {
                readln().toInt()
            } catch (e: NumberFormatException) {
                limpiarConsola()
                println("ERROR - VALOR NO VÁLIDO. INGRESE 1 PARA TERMINAR LA LLAMADA.")
                continue
            }

            if (teclado == 1) {
                val marca2 = timeSource.markNow()

                val duracionLlamada: Duration = marca2 - marca1
                println("DURACIÓN EN SEGUNDOS: $duracionLlamada")

                val minutosLlamada = duracionLlamada.inWholeSeconds.toFloat() / 60
                println("DURACIÓN EN: $minutosLlamada minutos")

                val llamada = Llamada(tipoLlamada, minutosLlamada, numeroCabina)
                registroLlamadas.add(llamada)

                val precioFormateado = String.format("%.2f", llamada.calcularValor())
                println("Valor llamada: $$precioFormateado")
                break
            } else {
                limpiarConsola()
                println("ERROR - VALOR NO VÁLIDO. INGRESE 1 PARA TERMINAR LA LLAMADA.")
            }
        }
    }

    // Método para borrar todos los registros de llamadas en la cabina
    fun borrarRegistroCabina() {
        limpiarConsola()
        registroLlamadas.clear() // Eliminar todos los elementos de la lista de llamadas
        println("REGISTRO DE LLAMADAS BORRADO.")
    }

    // Método para registrar una llamada manualmente
    fun registrarLlamada() {
        var duracionLlamadaRegistro = 0
        var tipoLlamada = ""

        limpiarConsola()
        println("INGRESE EL TIPO DE LLAMADA A REGISTRAR")
        val entradaTeclado = imprimirMenuLlamada()

        // Determinar el tipo de llamada basado en la entrada del usuario
        when (entradaTeclado) {
            1 -> tipoLlamada = "local"
            2 -> tipoLlamada = "internacional"
            3 -> tipoLlamada = "celular"
            4 -> {
                limpiarConsola()
                imprimirMenuPrincipal()
                return
            }
            else -> {
                limpiarConsola()
                println("ERROR - OPCIÓN NO VÁLIDA.")
                return
            }
        }

        // Bucle para ingresar la duración de la llamada
        while (true) {
            limpiarConsola()
            println("INGRESE LA DURACION DE LA LLAMADA (EN MINUTOS)")
            duracionLlamadaRegistro = try {
                readln().toInt()
            } catch (e: NumberFormatException) {
                limpiarConsola()
                println("ERROR - VALOR NO VÁLIDO.")
                continue
            }
            break
        }

        val llamada = Llamada(tipoLlamada, duracionLlamadaRegistro.toFloat(), numeroCabina)
        registroLlamadas.add(llamada)
        println("LLAMADA REGISTRADA.")
    }

    // Método para mostrar un resumen de todas las llamadas en la cabina
    fun resumenCabina() {
        var valorTotal = 0f
        var duracionTotal = 0f

        println("------------------------------------------------------------------------------")
        println("RESUMEN DE LLAMADAS - CABINA #$numeroCabina")
        println("------------------------------------------------------------------------------")
        println(String.format("%-15s %-20s %-20s %-10s", "VALOR", "TIPO", "DURACION", "#CABINA"))
        println("------------------------------------------------------------------------------")

        // Iterar sobre el registro de llamadas y mostrar detalles
        for (llamada in registroLlamadas) {
            valorTotal += llamada.calcularValor()
            duracionTotal += llamada.duracion

            println(
                String.format(
                    "$%-14.2f %-20s %-19.2f %-10d",
                    llamada.calcularValor(),
                    llamada.tipoLlamada,
                    llamada.duracion,
                    llamada.cabina
                )
            )
        }

        println("------------------------------------------------------------------------------")
        println("TOTAL DURACION LLAMADAS: ${String.format("%.2f", duracionTotal)} min")
        println("TOTAL VALOR: $${String.format("%.2f", valorTotal)}")
        val costoPromedioPorMinuto = if (duracionTotal > 0) valorTotal / duracionTotal else 0f
        println("COSTO PROMEDIO POR MINUTO: $${String.format("%.2f", costoPromedioPorMinuto)}")
    }
}
