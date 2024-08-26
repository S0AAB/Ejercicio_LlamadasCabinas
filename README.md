# Sistema de Gestión de Llamadas Telefónicas

## Descripción General
Este proyecto implementa un sistema de gestión de llamadas telefónicas para una empresa que cuenta con cinco cabinas telefónicas. Desarrollado en Kotlin, el sistema permite a los usuarios realizar, registrar, y gestionar las llamadas desde cada cabina, con funcionalidades adicionales para visualizar resúmenes y eliminar registros.

## Estructura del Proyecto
El sistema está compuesto por las siguientes clases y archivos:

- **Main.kt**: Clase principal que controla el flujo del programa y maneja la interacción del usuario a través de un menú de opciones.
- **Cabina.kt**: Clase que representa una cabina telefónica. Gestiona las llamadas realizadas en una cabina específica.
- **Llamada.kt**: Clase que define las características de una llamada, incluyendo su tipo, duración y costo.
- **Utilidades.kt**: Archivo que contiene funciones auxiliares como limpieza de la consola y la impresión de menús.

## Funcionalidades

### Gestión de Cabinas Telefónicas
- Permite la administración de cinco cabinas telefónicas numeradas del 1 al 5.
- Posibilidad de seleccionar una cabina para realizar o registrar llamadas.

### Realizar Llamadas
- Los usuarios pueden iniciar una llamada desde una cabina seleccionada.
- Elección del tipo de llamada: local, internacional o celular.
- Cálculo y visualización de la duración y el costo de la llamada.

### Registro de Llamadas
- Registro manual de llamadas con detalles de duración y tipo.
- Visualización de un resumen detallado de las llamadas realizadas por cada cabina.

### Gestión de Registros
- Eliminación de registros de llamadas por cabina o de todas las cabinas en conjunto.
- Visualización de un resumen general de todas las cabinas, mostrando la duración total de llamadas y el costo acumulado.

## Requisitos de Instalación
- **Kotlin**: Asegúrese de tener instalado Kotlin en su entorno de desarrollo.
- **IDE**: Es recomendable utilizar IntelliJ IDEA u otro IDE compatible con Kotlin.

## Ejecución del Proyecto
1. Clone el repositorio en su máquina local.
2. Abra el proyecto en su IDE preferido.
3. Compile y ejecute el archivo `Main.kt` para iniciar el programa.
4. Siga las instrucciones en pantalla para interactuar con el sistema a través del menú principal.

## Posibles Mejoras
- **Manejo Avanzado de Errores**: Implementar un manejo más robusto de excepciones para capturar y manejar situaciones inesperadas, mejorando la resiliencia del sistema.
- **Persistencia de Datos**: Incorporar una base de datos para almacenar los registros de llamadas, permitiendo que la información persista entre sesiones y sea accesible posteriormente.
- **Interfaz de Usuario Mejorada**: Desarrollar una interfaz gráfica (GUI) utilizando JavaFX o una biblioteca similar para mejorar la usabilidad y hacer el sistema más intuitivo para los usuarios.
- **Funcionalidad de Reportes**: Agregar la capacidad de generar reportes en PDF o Excel que detallen las llamadas realizadas y sus costos asociados por cabina o en general.
- **Autenticación de Usuarios**: Implementar un sistema de autenticación para que solo usuarios autorizados puedan acceder a las diferentes funcionalidades del sistema.

## Contribuciones
Las contribuciones al proyecto son bienvenidas. Si desea colaborar, puede hacer un fork del repositorio y enviar un pull request con las mejoras o nuevas funcionalidades propuestas.




