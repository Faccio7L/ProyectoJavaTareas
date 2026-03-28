package JavaProject;

public class GestorTareas {
	//aca va a estar el conjunto de desarrollares y el diccionario y la cola.
	ColaPrioridad colaPendientes;
	
	
	public GestorTareas() {
		//CONSTRUCTOR, INICIALIZAMOS DESARROLLADORES,DICCIONARIO Y COLA.
		this.colaPendientes = new ColaPrioridad();
		this.colaPendientes.inicializarCola();
	}
	
												//UTILIZAN OBJETOS TAREA!!!!
	public static void gestionarTareas(int n) {
        // Punto de entrada desde el main
        // Invoca a: crearTarea, eliminarTarea, actualizarEstado, listarTareasPorEstado. RECIBE UN NUMERO SEGUN LA FUNCION A INVOCAR.
		if (n == 1) {
		System.out.println("Texto de prueba");
    }}
	
	

    public void crearTarea(int id, String nombre, String desc, int prioridad) {
        // Invoca a: asignarDesarrolladorATarea.
    }

    public void eliminarTarea(int id) {
        // Invoca a: cambiarDisponibilidad (para liberar al dev asignado)
    }

    public void actualizarEstado(int id, String nuevoEstado) {
        // Invoca a: TareaCompleta SOLO SI EL NUEVO ESTADO ES COMPLETADO.
    }

    public void TareaCompleta(int id) {
        // ELIMINA TAREA.
        // Invoca a: cambiarDisponibilidad PARA LIBERAR AL DESARROLLADOR.
    }

    public void listarTareasPorEstado(String estado) {
        // USA EL DICT DE TAREAS.
    }

    									// LOS SIGUIENTES METODOS USA OBJETOS DESARROLLADOR!!!!!!!!!
    

    public void asignarDesarrolladorATarea(int idTarea, String nombreDev) {
        // Busca en el Set y vincula a la Tarea
        // Invoca a: cambiarDisponibilidad
    }

    public void cambiarDisponibilidad(String nombreDev, boolean estaOcupado) {
        // MÉTODO DE APOYO FINAL: Cambia el boolean 'ocupado' en el objeto del Set.
        // Es invocado por: asignarDesarrolladorATarea, eliminarTarea, TareaCompleta.
    }
}
