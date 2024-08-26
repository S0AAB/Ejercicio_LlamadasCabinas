/**
 * Limpia la consola imprimiendo 50 líneas en blanco.
 *
 * Esta función se utiliza para limpiar la pantalla de la consola,
 * proporcionando una forma de eliminar el texto previo y hacer que
 * la salida sea más legible. Es útil para redibujar menús o mostrar
 * nuevos contenidos sin la distracción del texto anterior.
 */
fun limpiarConsola() {
    repeat(50) {
        println()
    }
}
/**
 * Imprime el menú para seleccionar el tipo de llamada y devuelve la opción seleccionada por el usuario.
 *
 * El menú permite al usuario elegir entre:
 * 1. Llamada local
 * 2. Llamada internacional
 * 3. Llamada celular
 * 4. Salir del menú
 *
 * @return Un entero que representa la opción seleccionada por el usuario (entre 1 y 4).
 * Si el usuario ingresa un valor no válido, se muestra un mensaje de error y se vuelve a solicitar la entrada.
 */
fun imprimirMenuLlamada(): Int {
    while (true) {
        println("------------------")
        println("MENU TIPO LLAMADA")
        println("------------------")
        println("\n1.LLAMADA LOCAL\n2.LLAMADA INTERNACIONAL\n3.LLAMADA CELULAR\n4.SALIR")
        val entradaTeclado = try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            limpiarConsola()
            println("ERROR - VALOR NO VÁLIDO. INGRESE UN NÚMERO ENTRE 1 Y 4.")
            continue
        }

        if (entradaTeclado in 1..4) {
            return entradaTeclado
        } else {
            limpiarConsola()
            println("ERROR - VALOR NO VÁLIDO. INGRESE UN NÚMERO ENTRE 1 Y 4.")
        }
    }
}
/**
 * Imprime el menú principal y devuelve la opción seleccionada por el usuario.
 *
 * El menú principal ofrece las siguientes opciones:
 * 1. Hacer llamada
 * 2. Registrar llamada
 * 3. Borrar llamadas de cabina
 * 4. Resumen de llamadas por cabina
 * 5. Borrar todas las llamadas
 * 6. Resumen general
 * 7. Salir del programa
 *
 * @return Un entero que representa la opción seleccionada por el usuario (entre 1 y 7).
 * Si el usuario ingresa un valor no válido, se muestra un mensaje de error y se vuelve a solicitar la entrada.
 */
fun imprimirMenuPrincipal(): Int {
    while (true) {
        limpiarConsola()
        println("---------------")
        println("MENU PRINCIPAL")
        println("---------------")
        println("1.HACER LLAMADA \n2.REGISTRAR LLAMADA\n3.BORRAR LLAMADAS CABINA\n4.RESUMEN LLAMADAS POR CABINA\n5.BORRAR TODAS LAS LLAMADAS\n6.RESUMEN GENERAL\n7.SALIR")
        val entradaTeclado = try {
            readln().toInt()
        } catch (e: NumberFormatException) {
            limpiarConsola()
            println("ERROR - VALOR NO VÁLIDO. INGRESE UN NÚMERO ENTRE 1 Y 7.")
            continue
        }

        if (entradaTeclado in 1..7) {
            return entradaTeclado
        } else {
            limpiarConsola()
            println("ERROR - VALOR NO VÁLIDO. INGRESE UN NÚMERO ENTRE 1 Y 7.")
        }
    }
}


