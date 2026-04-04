package JavaProject;



public class GestorTareas {
	
	ColaPrioridad colaPendientes;
	static ConjuntoTDA conjunto = new ConjuntoImplementacionDevs(); //se crea conjunto al llamar clase GestorTareas.
	
	public GestorTareas() {
		//CONSTRUCTOR, INICIALIZAMOS DESARROLLADORES,DICCIONARIO Y COLA de MANERA AUTOMATICA.
		//HARDCODEO DE DESARROLLADORES.
		this.colaPendientes = new ColaPrioridad();
		this.colaPendientes.inicializarCola();
		
		conjunto.InicializarConjunto();
		
		Desarrollador d1 = new Desarrollador();
        d1.setNombre("Juan");
        d1.setOcupado(false);
        d1.setDni(67323492);

        Desarrollador d2 = new Desarrollador();
        d2.setNombre("Ana");
        d2.setOcupado(false);
        d2.setDni(3231323);

        Desarrollador d3 = new Desarrollador();
        d3.setNombre("luis");
        d3.setOcupado(false);
        d3.setDni(47675046);

        
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
    	Desarrollador dev = asignarDesarrolladorATarea(tarea);//devolveria el id de dev, lo podriamos hacer con nombre tambien.
    	if (dev == null) {
    		System.out.println("No hay desarrolladores disponibles.");
    	}
    	else {
    	tarea.setDev(dev);
        mostrartarea(tarea);
    }}
    
    public static void mostrartarea(Tarea tarea) {
    	Desarrollador d = tarea.getDev();
    	System.out.println("El nombre de su tarea es: " + tarea.getNombre());
    	System.out.println("Su descripcion es: " +  tarea.getDescripcion());
    	System.out.println("SU prioridad es: " + tarea.getPrioridad());
    	System.out.println("Su estado es:" + tarea.getEstado());
    	System.out.println("Su desarrollador a cargo es: " + d.getNombre());
    	
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
    	while (true) {
    	System.out.println("Ingrese 1 si desea ver los devs,2 si desea agregar,3 si desea eliminar,otro si desea salir.");
    	int op = scanner.InicializarScannerINT();
    	if (op == 1) {
    		verdevs();
    	}
    	else if (op == 2) {
    		
    		agregardevs();
    	}
    	else if (op == 3) {
    		
    		eliminardevs();
    	}
    	else{
    		break;
    		
    	}
    }
    }
    public static void verdevs() {
        ConjuntoTDA aux = new ConjuntoImplementacionDevs();
        aux.InicializarConjunto();
        int contador = 1;
        while (!conjunto.ConjuntoVacio()) {
            Desarrollador d = conjunto.Elegir();
            System.out.println("-----------" + contador + "----------");
            System.out.println("Nombre:"+d.getNombre());
            System.out.println("Ocupado:"+d.getOcupado());
            System.out.println("DNI: " +d.getDni());
            contador++;
            aux.Agregar(d);
            conjunto.SacarPorDNI(d.getDni());
     }

        //RESTAURAR!!!
        while (!aux.ConjuntoVacio()) {
            Desarrollador d = aux.Elegir();
            conjunto.Agregar(d);
            aux.SacarPorDNI(d.getDni());
  }
  }
    public static void agregardevs() {
    Desarrollador dev = new Desarrollador();
    System.out.println("Ingrese el nombre del desarrollador:");
    String nom = scanner.InicializarScannerSTR();
    System.out.println("Ingrese su dni");
    int num = scanner.InicializarScannerINT();
    dev.setNombre(nom);
    dev.setDni(num);
    dev.setOcupado(false);
    if( conjunto.Pertenece(dev)){
    	System.out.println("DNI ya ingresado.");
    }
    else {
    	conjunto.Agregar(dev);
    	System.out.println("Dev ingresado correctamente!!!");
    }
    
    }
    public static void eliminardevs() {
    	verdevs();
    	System.out.println("Ingrese el dni del desarrollador que quiere eliminar:");
    	int dni = scanner.InicializarScannerINT();
    	conjunto.SacarYNotificar(dni);
    
    }
    

    public static Desarrollador asignarDesarrolladorATarea(Tarea tarea) {
        // 1. Inicializamos el auxiliar
        ConjuntoTDA aux = new ConjuntoImplementacionDevs();
        aux.InicializarConjunto(); 
        
        Desarrollador devEncontrado = null;
        
        while (!conjunto.ConjuntoVacio()) {
            Desarrollador actual = conjunto.Elegir();
            conjunto.Sacar(actual);
            
            if (!actual.getOcupado() && devEncontrado == null) {
                devEncontrado = actual;
                devEncontrado.setOcupado(true); 
                tarea.setDev(devEncontrado); }
            
            
            aux.Agregar(actual); }
        
        while (!aux.ConjuntoVacio()) {
            Desarrollador paraDevolver = (Desarrollador) aux.Elegir();
            conjunto.Agregar(paraDevolver);
           
            aux.Sacar(paraDevolver);
        }
    return devEncontrado; 
 }

    public void cambiarDisponibilidad(String nombreDev, boolean estaOcupado) {
        // MÉTODO DE APOYO FINAL: Cambia el boolean 'ocupado' en el objeto del Set.
        // Es invocado por: asignarDesarrolladorATarea, eliminarTarea, TareaCompleta.
    }
}
