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
		crearTarea();
    }
}
	
	

    public static void crearTarea() {
    	// Invoca a: asignarDesarrolladorATarea.
    	Tarea tarea = new Tarea(); 
    	tarea.setId(tarea.getContadorId());
    	
    	System.out.println("Ingrese el nombre de la tarea:");
    	String nombre = scanner.InicializarScannerSTR();
    	tarea.setNombre(nombre);
    	
    	System.out.println("Escriba una breve descripcion:");
    	String descripcion = scanner.InicializarScannerSTR();
    	tarea.setDescripcion(nombre);
    	
    	System.out.println("Ingrese una prioridad: 1 baja,2 media, 3 alta");
    	int prioridad = scanner.InicializarScannerINT();
    	if (prioridad >= 1 && prioridad <= 3) {
    		tarea.setPrioridad(prioridad);	
    	}
    	
    	tarea.setEstado("Incompleta");
    	int dev = asignarDesarrolladorATarea(tarea.getId()); //devolveria el id de dev, lo podriamos hacer con nombre tambien.
    	tarea.setDev(dev);
        
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
    

    public static int asignarDesarrolladorATarea(int idTarea) {
        // Busca en el Set y vincula a la Tarea
        // Invoca a: cambiarDisponibilidad
    }

    public void cambiarDisponibilidad(String nombreDev, boolean estaOcupado) {
        // MÉTODO DE APOYO FINAL: Cambia el boolean 'ocupado' en el objeto del Set.
        // Es invocado por: asignarDesarrolladorATarea, eliminarTarea, TareaCompleta.
    }
}
