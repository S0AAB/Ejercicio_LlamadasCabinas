//SANTIAGO AHUMADA
fun main() {
    // Crear un mapa mutable que asocia números de cabina (1 a 5) con instancias de la clase Cabina.
    val cabinas = mutableMapOf<Int, Cabina>()
    for (i in 1..5) {
        cabinas[i] = Cabina(i)
    }

    // Bucle principal que mantiene el programa en ejecución hasta que el usuario elige salir.
    while (true) {
        // Mostrar el menú principal y capturar la opción seleccionada por el usuario.
        val teclado = imprimirMenuPrincipal()

        // Salir del bucle y terminar el programa si el usuario elige la opción de salida (7).
        if (teclado == 7) break

        var cabinaSeleccionada = 0
        if (teclado in 1..4) {  // Solo pedir la selección de cabina para opciones 1, 2, 3 y 4
            while (true) {
                // Limpiar la consola antes de mostrar las opciones de cabina.
                limpiarConsola()
                println("SELECCIONE LA CABINA QUE DESEA UTILIZAR (1 A 5)")
                println("1. CABINA 1")
                println("2. CABINA 2")
                println("3. CABINA 3")
                println("4. CABINA 4")
                println("5. CABINA 5")
                println("6. SALIR")

                // Intentar leer y convertir la entrada del usuario a un entero.
                cabinaSeleccionada = try {
                    readln().toInt()
                } catch (e: NumberFormatException) {
                    // Manejar la excepción si la entrada no es un número entero válido.
                    limpiarConsola()
                    println("ERROR - VALOR NO VÁLIDO.")
                    Thread.sleep(2000)
                    continue
                }

                // Verificar si el usuario selecciona la opción 6 (SALIR).
                if (cabinaSeleccionada == 6) break

                // Verificar si la selección está dentro del rango válido de cabinas.
                if (cabinaSeleccionada in 1..5) break
                else {
                    limpiarConsola()
                    println("ERROR - OPCIÓN NO VÁLIDA.")
                    Thread.sleep(2000)
                }
            }

            // Si el usuario seleccionó "6", se devuelve al menú principal.
            if (cabinaSeleccionada == 6) continue

            limpiarConsola()
            // Obtener la cabina seleccionada del mapa.
            val cabinaUtilizada = cabinas[cabinaSeleccionada]

            // Ejecutar la acción correspondiente según la opción del menú principal seleccionada.
            when (teclado) {
                // Opción 1: Realizar una llamada desde la cabina seleccionada.
                1 -> {
                    cabinaUtilizada?.llamar()
                    cabinaUtilizada?.resumenCabina()
                    Thread.sleep(3000)
                }
                // Opción 2: Registrar una llamada en la cabina seleccionada.
                2 -> {
                    cabinaUtilizada?.registrarLlamada()
                    cabinaUtilizada?.resumenCabina()
                    Thread.sleep(3000)
                }
                // Opción 3: Borrar todas las llamadas en la cabina seleccionada.
                3 -> {
                    cabinaUtilizada?.borrarRegistroCabina()
                    println("SE BORRARON TODAS LAS LLAMADAS DE CABINA: ${cabinaUtilizada?.numeroCabina}")
                    Thread.sleep(3000)
                }
                // Opción 4: Mostrar un resumen de todas las llamadas en la cabina seleccionada.
                4 -> {
                    println("------------------------------------------------------------------------------")
                    println("RESUMEN CABINA #${cabinaUtilizada?.numeroCabina}")
                    println("------------------------------------------------------------------------------")
                    println(String.format("%-15s %-20s %-20s %-10s", "VALOR", "TIPO", "DURACION", "#CABINA"))
                    println("------------------------------------------------------------------------------")

                    var valorTotal = 0f
                    var duracionTotal = 0f
                    var numLlamadas = 0

                    // Iterar sobre el registro de llamadas de la cabina seleccionada para calcular totales.
                    cabinaUtilizada?.registroLlamadas?.forEach { llamada ->
                        valorTotal += llamada.calcularValor()
                        duracionTotal += llamada.duracion
                        numLlamadas++

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
                    println("COSTO PROMEDIO POR MINUTO CABINA: $${String.format("%.2f", costoPromedioPorMinuto)}")

                    Thread.sleep(5000)
                }
            }
        } else {
            // Manejar las opciones que no requieren selección de cabina (5 y 6).
            when (teclado) {
                // Opción 5: Borrar todas las llamadas de todas las cabinas.
                5 -> {
                    limpiarConsola()
                    println("ESTÁS A PUNTO DE BORRAR TODAS LAS LLAMADAS DE TODAS LAS CABINAS.")
                    println("¿ESTÁS SEGURO? (S/N)")
                    val confirmacion = readln().uppercase()
                    if (confirmacion == "S") {
                        cabinas.values.forEach { cabina ->
                            cabina.borrarRegistroCabina() // Borra todas las llamadas en cada cabina.
                        }
                        println("TODAS LAS LLAMADAS HAN SIDO BORRADAS.")
                    } else {
                        println("OPERACIÓN CANCELADA.")
                    }
                    Thread.sleep(3000)
                }
                // Opción 6: Mostrar un resumen general de todas las llamadas en todas las cabinas.
                6 -> {
                    var valorTotal = 0f
                    var duracionTotal = 0f
                    var numLlamadas = 0
                    limpiarConsola()
                    println("RESUMEN GENERAL DE CABINAS:")
                    println(String.format("%-15s %-20s %-20s %-10s", "VALOR", "TIPO", "DURACION", "#CABINA"))
                    println("------------------------------------------------------------------------------")

                    // Iterar sobre el registro de llamadas de todas las cabinas para calcular totales.
                    cabinas.values.forEach { cabina ->
                        cabina.registroLlamadas.forEach { llamada ->
                            valorTotal += llamada.calcularValor()
                            duracionTotal += llamada.duracion
                            numLlamadas++

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
                    }

                    println("------------------------------------------------------------------------------")
                    println("TOTAL DURACION LLAMADAS: ${String.format("%.2f", duracionTotal)} min")
                    println("TOTAL VALOR: $${String.format("%.2f", valorTotal)}")
                    val costoPromedioPorMinuto = if (duracionTotal > 0) valorTotal / duracionTotal else 0f
                    println("COSTO PROMEDIO POR MINUTO: $${String.format("%.2f", costoPromedioPorMinuto)}")
                    Thread.sleep(10000)
                }
                // Opción no válida.
                else -> {
                    limpiarConsola()
                    println("ERROR - OPCIÓN NO VÁLIDA.")
                }
            }
        }
    }
}
