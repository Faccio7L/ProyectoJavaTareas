Gestor de Tareas Academico (Estructuras de Datos TDA)
Este proyecto consiste en un Gestor de Tareas desarrollado en Java con fines puramente academicos. El objetivo principal de la aplicacion es demostrar la implementacion practica y el uso de Tipos de Datos Abstractos (TDA) dinamicos y estructuras de datos estaticas o dinamicas avanzadas para resolver un problema de logica de negocio real relacionado a la administracion de flujos de trabajo de desarrollo de software.
La clase GestorTareas provista actua como el corazon y nucleo logico del sistema, coordinando el almacenamiento, asignacion, modificacion y ciclo de vida de las tareas utilizando abstracciones logicas de TDAs en lugar de las colecciones nativas de Java como ArrayList o HashMap.
Proposito Academico
Este desarrollo fue estructurado bajo las restricciones tipicas de una catedra de Estructuras de Datos / Programacion Orientada a Objetos, donde se prohibe el uso de utilidades nativas de java.util.* para el almacenamiento de datos. En su lugar, el flujo se basa rigurosamente en interfaces e implementaciones axiomaticas de TDAs:
Abstraccion de Datos: Separacion estricta entre la interfaz de la estructura (TDA) y su implementacion concreta.
Manipulacion Destructiva: Recorrido y filtrado de estructuras mediante el uso de contenedores auxiliares e invariantes de ciclo como Elegir(), Sacar() o Desacolar(), preservando el estado original al finalizar la operacion.
Algoritmia de Busqueda Local: Implementacion de logicas fail-fast basadas en recorridos secuenciales sin romper el encapsulamiento.
Arquitectura de Estructuras (Los TDAs Utilizados)
El nucleo del sistema gestiona la persistencia en memoria y la prioridad de ejecución mediante tres estructuras fundamentales:
ColaPrioridadTDA (Priorizacion de Ejecucion):
Proposito: Almacena las tareas pendientes organizadas por su nivel de criticidad (1: Baja, 2: Media, 3: Alta).
Uso: Permite que el metodo realizarTarea() atienda siempre primero a los requerimientos mas urgentes acoplados al TDA.
ConjuntoTDA (Gestion de Recursos y Desarrolladores):
Proposito: Almacena la bolsa de desarrolladores disponibles en el sistema sin un orden particular y garantizando la unicidad mediante validacion de DNI con conjunto.Pertenece(dev).
Uso: Permite elegir recursos al azar con Elegir() para asignacion de tareas y controlar estados de disponibilidad.
DiccionarioSimpleTDA (Indexacion y Acceso Directo):
Proposito: Mapea un identificador unico numerico (id) con la instancia del objeto Tarea.
Uso: Crucial para busquedas instantaneas, consultas de estados con verEstadoTarea() y modificaciones en caliente de propiedades sin desarmar la cola de prioridad de forma innecesaria.
Funcionalidades Implementadas en el Corazon del Sistema
El metodo modular gestionarTareas(int n) actua como el despachador del menu principal, habilitando las siguientes operaciones:
crearTarea() (Opcion 1): Aplica validacion fail-fast verificando disponibilidad de desarrolladores en el ConjuntoTDA. Captura datos por consola, genera IDs unicos y acola la tarea segun su prioridad, registrandola en simultaneo en el diccionario de busqueda rapida.
seleccionarPorPrioridad() (Opcion 2): Permite filtrar e imprimir en pantalla las tareas que coincidan exactamente con un nivel de prioridad seleccionado, utilizando una cola auxiliar para no destruir el ordenamiento original.
eliminarTarea() (Opcion 3): Remueve una tarea del diccionario de busqueda y recorre destructivamente la cola de prioridad para extraer el nodo correspondiente, liberando automaticamente al desarrollador asignado con cambiarDisponibilidad().
realizarTarea() (Opcion 4): Avanza el ciclo de vida de la tarea al frente de la cola passando de Incompleta a En proceso y finalmente a Completo. Al completarse, libera al desarrollador y la remueve de la cola de pendientes.
modificarTarea() (Opcion 5): Permite la edicion interactiva de campos como Nombre, Descripcion, Prioridad o Desarrollador asignado. Si la prioridad cambia, el sistema automaticamente re-estructura y re-ordena la ColaPrioridadTDA.
AdministrarDevs() (Opcion 6): Ofrece un submenu para dar de alta nuevos desarrolladores, listar el estado de ocupacion de todo el personal o eliminar recursos del sistema siempre y cuando su estado sea No Ocupado.
verEstadoTarea() (Opcion 7): Recuperacion directa mediante clave ID usando el diccionario para auditoria rapida del estado del requerimiento.
