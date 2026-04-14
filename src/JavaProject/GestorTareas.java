package JavaProject;

public class GestorTareas {
	
	static ColaPrioridadTDA cola = new ColaPrioridadImplementacion();
	static ConjuntoTDA conjunto = new ConjuntoImplementacionDevs(); //se crea conjunto al llamar clase GestorTareas.
    static DiccionarioSimpleTDA diccionario = new DiccionarioSimpleImplementacion();
	public GestorTareas() {
		//CONSTRUCTOR, INICIALIZAMOS DESARROLLADORES,DICCIONARIO Y COLA de MANERA AUTOMATICA.
		//HARDCODEO DE DESARROLLADORES.
		cola.InicializarCola();;
		
		conjunto.InicializarConjunto();

        diccionario.InicializarDiccionario();

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
		else if(n==2) {
		seleccionarPorPrioridad();
		}
		else if(n==3){
			eliminarTarea();
		}
		else if(n==4){
			realizarTarea();
		}
        else if(n==5){
            modificarTarea();
        }
		else if (n==6) {
		AdministrarDevs();

    }
	else if (n==7) {
		verEstadoTarea();
	}
}

	//Opción 7
	public static void verEstadoTarea() {
		System.out.println("Ingrese el ID de la tarea:");
		int id = scanner.InicializarScannerINT();
		if (diccionario.ExisteClave(id)) {
			Tarea tarea = diccionario.Recuperar(id);
			// Nota: Se acepta 'Incompleto' para mantener compatibilidad con el código de mis compañeros.
			System.out.println("Nombre: " + tarea.getNombre());
			System.out.println("Estado: " + tarea.getEstado());
		} else {
			System.out.println("No se encontró una tarea con ese ID.");
		}
	}
	public static void seleccionarPorPrioridad() {
		while (true) {
		System.out.println("Ingrese 1 para ver tareas de baja prioridad,2 para ver de prioridad media,3 para ver de prioridad alta.");
		int op = scanner.InicializarScannerINT();
		if (op >= 1 && op <= 3) {
			verPorPrioriedad(op);
			break;
		}
		else {
			System.out.println("Numero invalido;");
		}
	}
}
	
	public static void verPorPrioriedad(int x) {
		ColaPrioridadTDA aux = new ColaPrioridadImplementacion();
		aux.InicializarCola();
		while (!cola.ColaVacia()) {
			Tarea t = cola.Primero();
			
			cola.Desacolar();
			if( t.getPrioridad() == x) {
				
				mostrartarea(t);
			}
			aux.AcolarPrioridad(t, t.getPrioridad());
		}

		System.out.println("No quedan mas tareas por mostrar!!!");
		while(!aux.ColaVacia()) {
			Tarea t = aux.Primero();
			aux.Desacolar();
			cola.AcolarPrioridad(t, t.getPrioridad());
		}
	}

	//Opción 1
    public static void crearTarea() {
    	
    	Tarea tarea = new Tarea(); 
    	tarea.setId();
    	
    	System.out.println("Ingrese el nombre de la tarea:");
    	String nombre = scanner.InicializarScannerSTR();
    	tarea.setNombre(nombre);
    	
    	System.out.println("Escriba una breve descripcion:");
    	String descripcion = scanner.InicializarScannerSTR();
    	tarea.setDescripcion(descripcion);
    	
    	System.out.println("Ingrese una prioridad: 1 baja,2 media, 3 alta");
    	int prioridad = scanner.InicializarScannerINT();
		while(prioridad<1 || prioridad>3){
			System.out.println("La prioridad no está en el rango permitido, por favor, inserte un valor válido");
			System.out.println("Ingrese una prioridad: 1 baja,2 media, 3 alta");
    		prioridad = scanner.InicializarScannerINT();
		}
    	if (prioridad >= 1 && prioridad <= 3) {
    		tarea.setPrioridad(prioridad);	
    	}
    	
    	tarea.setEstado("Incompleta");
    	Desarrollador dev = asignarDesarrolladorATarea(tarea);//devolveria el id de dev, lo podriamos hacer con nombre tambien.
																	//el tema de hacerlo con nombre es que no es único, a lo mejor podemos hacerlo con id y que devuelva el nombre como comprobación, si es que tienen ganas
    	if (dev == null) {
    		System.out.println("No hay desarrolladores disponibles.");
    	}
    	else {
    	tarea.setDev(dev);
        mostrartarea(tarea);
        cola.AcolarPrioridad(tarea, prioridad);
        diccionario.Agregar(tarea.getId(), tarea);
		}
	}
	//Opción 2
    public static void mostrartarea(Tarea tarea) {
    	System.out.println("----------------------<>----------------------");
    	Desarrollador d = tarea.getDev(); //tarea tiene como atributo objeto dev, dev tiene como atributo nombre.
    	System.out.println("El nombre de su tarea es: " + tarea.getNombre());
    	System.out.println("Su id es:" + tarea.getId());
    	System.out.println("Su descripcion es: " +  tarea.getDescripcion());
    	System.out.println("Su prioridad es: " + tarea.getPrioridad());
    	System.out.println("Su estado es:" + tarea.getEstado());
    	System.out.println("Su desarrollador a cargo es: " + d.getNombre());
    	System.out.println("ENTER PARA CONTINUAR");
    	scanner.InicializarScannerSTR();
    	System.out.println("---------------------<>-----------------------");
    }

	//Opción 3
    public static void eliminarTarea() {
        // Invoca a: cambiarDisponibilidad (para liberar al dev asignado)
    	System.out.println("Ingrese el ID de la tarea que quiera eliminar, 0 para retroceder:");
		int op = scanner.InicializarScannerINT();
		if (op == 0){
			return;
		}
		else{
			boolean existe =  buscarEnCola(op);
			if (existe){
				diccionario.Eliminar(op);
			}
		}
	}

	public static boolean buscarEnCola(int id) {
		ColaPrioridadTDA aux = new ColaPrioridadImplementacion();
		aux.InicializarCola();
		boolean encontrada = false;


		while (!cola.ColaVacia()) {
			Tarea t = cola.Primero();
			if (t.getId() == id) {
				encontrada = true;
				System.out.println("Eliminando...");
				Desarrollador dev = t.getDev();
				System.out.println("Su dev" + dev.getNombre() + "ha sido liberado!!!");
				cambiarDisponibilidad(dev); // si la encuentra, obtiene su dev y le cambia el estado.
			}
			aux.AcolarPrioridad(t, t.getPrioridad());
			cola.Desacolar();
		}

		while (!aux.ColaVacia()) {
			cola.AcolarPrioridad(aux.Primero(), aux.Primero().getPrioridad());
			aux.Desacolar();
		}

		return encontrada;
	}

	//Opción 4
	public static void realizarTarea() {
		Tarea t = cola.Primero();

		System.out.println("La siguiente tarea es " + t.getNombre());
		System.out.println("SU Estado actual: " + t.getEstado());
		System.out.println("Ingrese SI EN MAYUSC. para avanzar con la tarea:");
		String op = scanner.InicializarScannerSTR();
		if (op.equals("SI")) {

			if (t.getEstado().equals("Incompleta")) {
				t.setEstado("En proceso");
				diccionario.Agregar(t.getId(), t);
				System.out.println("La tarea paso a estar: EN PROCESO.");


			} else if (t.getEstado().equals("En proceso")) {
				cola.Desacolar();
				t.setEstado("completo");
				diccionario.Agregar(t.getId(), t);
				System.out.println("Tarea COMPLETADA con exito.");
			}
		}
	       }

	//Opción 5
    public void listarTareasPorEstado(String estado) {
        System.out.println("Ingrese 1 si desea ver las tareas incompletas,2 en proceso o 3 para tareas completas.");
    }

    public void TareaCompleta(int id) {
    // ELIMINA TAREA.
    // Invoca a: cambiarDisponibilidad PARA LIBERAR AL DESARROLLADOR.
	}

	//Opción 6
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
    	System.out.println("NOTA: DEBE ESTAR DISPONIBLE PARA ELIMINARLO!");
    	int dni = scanner.InicializarScannerINT();
    	if (conjunto.BuscarPorDNIDisponibilidad(dni)) {
    	conjunto.SacarYNotificar(dni);
    	}
    	else {
    		System.out.println("No existe o puede que este ocupado.");
    	}
    }

    public static Desarrollador asignarDesarrolladorATarea(Tarea tarea) {
        
        ConjuntoTDA aux = new ConjuntoImplementacionDevs();
        aux.InicializarConjunto(); 
        
        Desarrollador devEncontrado = null;
        
        while (!conjunto.ConjuntoVacio()) {
            Desarrollador actual = conjunto.Elegir();
            conjunto.Sacar(actual);
            
            if (!actual.getOcupado() && devEncontrado == null) {
              devEncontrado = actual;
              cambiarDisponibilidad(devEncontrado);
              tarea.setDev(devEncontrado); }
            
            aux.Agregar(actual); 
		}
        
        while (!aux.ConjuntoVacio()) {
            Desarrollador paraDevolver = (Desarrollador) aux.Elegir();
            conjunto.Agregar(paraDevolver);
           
            aux.Sacar(paraDevolver);
        }
    return devEncontrado; 
}

    public static void cambiarDisponibilidad(Desarrollador dev) {
        // cambia el estado del dev.
    	boolean estado = dev.getOcupado();
    	if (estado) {
    		dev.setOcupado(false);
    	}
    	else {
    		dev.setOcupado(true);
    	}
	}
    public static void modificarTarea() {
        System.out.println("Ingrese el ID de la tarea que desea modificar, 0 para retroceder:");
        int id = scanner.InicializarScannerINT();
        if (id == 0) {
            return;
        }

        if (!diccionario.ExisteClave(id)) {
            System.out.println("No se encontró una tarea con ese ID.");
            return;
        }

        Tarea tarea = diccionario.Recuperar(id);
        boolean prioridadCambiada = false;
        boolean modificando = true;

        while (modificando) {
            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Descripción");
            System.out.println("3. Prioridad");
            System.out.println("4. Desarrollador asignado");
            System.out.println("0. Finalizar modificación");
            int op = scanner.InicializarScannerINT();

            if (op == 1) {
                System.out.println("Nombre actual: " + tarea.getNombre());
                System.out.println("Ingrese el nuevo nombre:");
                String nuevoNombre = scanner.InicializarScannerSTR();
                tarea.setNombre(nuevoNombre);
                System.out.println("Nombre actualizado.");

            } else if (op == 2) {
                System.out.println("Descripción actual: " + tarea.getDescripcion());
                System.out.println("Ingrese la nueva descripción:");
                String nuevaDesc = scanner.InicializarScannerSTR();
                tarea.setDescripcion(nuevaDesc);
                System.out.println("Descripción actualizada.");

            } else if (op == 3) {
                System.out.println("Prioridad actual: " + tarea.getPrioridad());
                System.out.println("Ingrese la nueva prioridad: 1 baja, 2 media, 3 alta");
                int nuevaPrioridad = scanner.InicializarScannerINT();
                while (nuevaPrioridad < 1 || nuevaPrioridad > 3) {
                    System.out.println("Valor inválido. Ingrese 1, 2 o 3:");
                    nuevaPrioridad = scanner.InicializarScannerINT();
                }
                tarea.setPrioridad(nuevaPrioridad);
                prioridadCambiada = true;
                System.out.println("Prioridad actualizada.");

            } else if (op == 4) {
                Desarrollador devActual = tarea.getDev();
                System.out.println("Desarrollador actual: " + devActual.getNombre());
                Desarrollador nuevoDev = asignarDesarrolladorATarea(tarea);
                if (nuevoDev == null) {
                    System.out.println("No hay otros desarrolladores disponibles. Se mantiene el actual.");
                } else {
                    cambiarDisponibilidad(devActual);
                    tarea.setDev(nuevoDev);
                    System.out.println("Desarrollador cambiado a: " + nuevoDev.getNombre());
                }

            } else if (op == 0) {
                modificando = false;
            } else {
                System.out.println("Opción inválida.");
            }
        }

        diccionario.Agregar(tarea.getId(), tarea);

        if (prioridadCambiada) {
            ColaPrioridadTDA aux = new ColaPrioridadImplementacion();
            aux.InicializarCola();
            while (!cola.ColaVacia()) {
                Tarea t = cola.Primero();
                cola.Desacolar();
                if (t.getId() != id) {
                    aux.AcolarPrioridad(t, t.getPrioridad());
                }
            }
            aux.AcolarPrioridad(tarea, tarea.getPrioridad());
            while (!aux.ColaVacia()) {
                Tarea t = aux.Primero();
                aux.Desacolar();
                cola.AcolarPrioridad(t, t.getPrioridad());
            }
        }

        mostrartarea(tarea);
        System.out.println("Tarea modificada con éxito.");
    }
}
