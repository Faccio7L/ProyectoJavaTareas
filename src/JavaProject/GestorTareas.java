package JavaProject;



public class GestorTareas {
	
	ColaPrioridad colaPendientes;
	static ConjuntoTDA conjunto = new ConjuntoImplementacionDevs();
	
	public GestorTareas() {
		//CONSTRUCTOR, INICIALIZAMOS DESARROLLADORES,DICCIONARIO Y COLA.
		//HARDCODEO DE DESARROLLADORES.
		this.colaPendientes = new ColaPrioridad();
		this.colaPendientes.inicializarCola();
		conjunto.InicializarConjunto();
		
		Desarrollador d1 = new Desarrollador();
        d1.setNombre("Juan");
        d1.setOcupado(false);

        Desarrollador d2 = new Desarrollador();
        d2.setNombre("Ana");
        d2.setOcupado(false);

        Desarrollador d3 = new Desarrollador();
        d3.setNombre("luis");
        d3.setOcupado(false);

        
        conjunto.Agregar(d1);
        conjunto.Agregar(d2);
        conjunto.Agregar(d3);
	}
	
												//UTILIZAN OBJETOS TAREA!!!!
	public static void gestionarTareas(int n) {
        // Punto de entrada desde el main
        // Invoca a: crearTarea, eliminarTarea, actualizarEstado, listarTareasPorEstado. RECIBE UN NUMERO SEGUN LA FUNCION A INVOCAR.
		if (n == 1) {
		crearTarea();
		}
		else if (n==5) {
		AdministrarDevs();
		
    }
}
	
	

    public static void crearTarea() {
    	// Invoca a: asignarDesarrolladorATarea.
    	/*
    	if (ConjuntoVacio) {
    		
    		System.out.println("No hay desarrolladores disponibles, lo sentimos.");
    		return
    	}
    	*/
    	Tarea tarea = new Tarea(); 
    	tarea.setId(tarea.getContadorId());
    	
    	System.out.println("Ingrese el nombre de la tarea:");
    	String nombre = scanner.InicializarScannerSTR();
    	tarea.setNombre(nombre);
    	
    	System.out.println("Escriba una breve descripcion:");
    	String descripcion = scanner.InicializarScannerSTR();
    	tarea.setDescripcion(descripcion);
    	
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
    public static void AdministrarDevs() {
    	
    	System.out.println("Ingrese 1 si desea ver los devs,2 si desea agregar,3 si desea eliminar:");
    	int op = scanner.InicializarScannerINT();
    	if (op == 1) {
    		verdevs();
    	}
    }
    public static void verdevs() {
        ConjuntoTDA aux = new ConjuntoImplementacionDevs();
        aux.InicializarConjunto();

        while (!conjunto.ConjuntoVacio()) {
            Desarrollador d = conjunto.Elegir();
            System.out.println("Nombre:"+d.getNombre());
            System.out.println("Disponible:"+(!d.isOcupado()));

            aux.Agregar(d);
            conjunto.Sacar(d);
     }

        //RESTAURAR!!!
        while (!aux.ConjuntoVacio()) {
            Desarrollador d = aux.Elegir();
            conjunto.Agregar(d);
            aux.Sacar(d);
  }
  }

    public static int asignarDesarrolladorATarea(int idTarea) {
        // Busca en el Set y vincula a la Tarea
        // Invoca a: cambiarDisponibilidad
    	
    	
    }

    
    public void cambiarDisponibilidad(String nombreDev, boolean estaOcupado) {
        // MÉTODO DE APOYO FINAL: Cambia el boolean 'ocupado' en el objeto del Set.
        // Es invocado por: asignarDesarrolladorATarea, eliminarTarea, TareaCompleta.
    }
}
