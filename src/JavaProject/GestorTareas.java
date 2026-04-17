package JavaProject;

public class GestorTareas {

    static ColaPrioridadTDA cola = new ColaPrioridadImplementacion();
    static ConjuntoTDA conjunto = new ConjuntoImplementacionDevs();
    static DiccionarioSimpleTDA diccionario = new DiccionarioSimpleImplementacion();

    public GestorTareas() {
        // CONSTRUCTOR: inicializamos estructuras y cargamos devs de ejemplo.
        cola.InicializarCola();
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

    // ---------------------------------------------------------------
    // MÉTODOS AUXILIARES PRIVADOS (lógica que antes estaba en el TDA)
    // ---------------------------------------------------------------

    /**
     * Saca un desarrollador del conjunto buscándolo por DNI.
     * Usa estructura auxiliar para recorrer el conjunto.
     */
    private static void sacarDeConjuntoPorDNI(ConjuntoTDA conj, int dni) {
        ConjuntoTDA aux = new ConjuntoImplementacionDevs();
        aux.InicializarConjunto();
        while (!conj.ConjuntoVacio()) {
            Desarrollador d = conj.Elegir();
            conj.Sacar(d);
            if (d.getDni() != dni) {
                aux.Agregar(d);
            }
        }
        while (!aux.ConjuntoVacio()) {
            Desarrollador d = aux.Elegir();
            aux.Sacar(d);
            conj.Agregar(d);
        }
    }

    /**
     * Busca un dev por DNI. Si existe y está disponible (no ocupado),
     * lo saca del conjunto y retorna true. Si no existe o está ocupado, retorna false.
     */
    private static boolean buscarDisponiblePorDNI(ConjuntoTDA conj, int dni) {
        ConjuntoTDA aux = new ConjuntoImplementacionDevs();
        aux.InicializarConjunto();
        boolean disponible = false;

        while (!conj.ConjuntoVacio()) {
            Desarrollador d = conj.Elegir();
            conj.Sacar(d);
            if (d.getDni() == dni) {
                if (!d.getOcupado()) {
                    disponible = true;
                    // No se reactiva: queda eliminado del conjunto
                } else {
                    aux.Agregar(d); // Está ocupado, se mantiene
                }
            } else {
                aux.Agregar(d);
            }
        }
        while (!aux.ConjuntoVacio()) {
            Desarrollador d = aux.Elegir();
            aux.Sacar(d);
            conj.Agregar(d);
        }
        return disponible;
    }

    // ---------------------------------------------------------------
    // PUNTO DE ENTRADA
    // ---------------------------------------------------------------

    public static void gestionarTareas(int n) {
        if (n == 1) {
            crearTarea();
        } else if (n == 2) {
            seleccionarPorPrioridad();
        } else if (n == 3) {
            eliminarTarea();
        } else if (n == 4) {
            realizarTarea();
        } else if (n == 5) {
            modificarTarea();
        } else if (n == 6) {
            AdministrarDevs();
        } else if (n == 7) {
            verEstadoTarea();
        }
    }

    // ---------------------------------------------------------------
    // OPCIÓN 7
    // ---------------------------------------------------------------

    public static void verEstadoTarea() {
        System.out.println("Ingrese el ID de la tarea:");
        int id = scanner.InicializarScannerINT();
        if (diccionario.ExisteClave(id)) {
            Tarea tarea = diccionario.Recuperar(id);
            System.out.println("Nombre: " + tarea.getNombre());
            System.out.println("Estado: " + tarea.getEstado());
        } else {
            System.out.println("No se encontró una tarea con ese ID.");
        }
    }

    // ---------------------------------------------------------------
    // OPCIÓN 2
    // ---------------------------------------------------------------

    public static void seleccionarPorPrioridad() {
        while (true) {
            System.out.println("Ingrese 1 para ver tareas de baja prioridad, 2 para media, 3 para alta.");
            int op = scanner.InicializarScannerINT();
            if (op >= 1 && op <= 3) {
                verPorPrioriedad(op);
                break;
            } else {
                System.out.println("Numero invalido.");
            }
        }
    }

    public static void verPorPrioriedad(int x) {
        ColaPrioridadTDA aux = new ColaPrioridadImplementacion();
        aux.InicializarCola();
        while (!cola.ColaVacia()) {
            Tarea t = cola.Primero();
            cola.Desacolar();
            if (t.getPrioridad() == x) {
                mostrartarea(t);
            }
            aux.AcolarPrioridad(t, t.getPrioridad());
        }
        System.out.println("No quedan mas tareas por mostrar!!!");
        while (!aux.ColaVacia()) {
            Tarea t = aux.Primero();
            aux.Desacolar();
            cola.AcolarPrioridad(t, t.getPrioridad());
        }
    }

    // ---------------------------------------------------------------
    // OPCIÓN 1
    // ---------------------------------------------------------------

    public static void crearTarea() {
        // Validación fail-fast: verificar si hay al menos un desarrollador disponible
        ConjuntoTDA auxValidacion = new ConjuntoImplementacionDevs();
        auxValidacion.InicializarConjunto();
        boolean hayDisponible = false;

        while (!conjunto.ConjuntoVacio()) {
            Desarrollador d = conjunto.Elegir();
            if (!d.getOcupado()) {
                hayDisponible = true;
            }
            conjunto.Sacar(d);
            auxValidacion.Agregar(d);
        }
        while (!auxValidacion.ConjuntoVacio()) {
            Desarrollador d = auxValidacion.Elegir();
            conjunto.Agregar(d);
            auxValidacion.Sacar(d);
        }

        if (!hayDisponible) {
            System.out.println("No se pueden crear tareas: no hay desarrolladores disponibles en este momento.");
            return;
        }

        Tarea tarea = new Tarea();
        tarea.setId();

        System.out.println("Ingrese el nombre de la tarea:");
        String nombre = scanner.InicializarScannerSTR();
        tarea.setNombre(nombre);

        System.out.println("Escriba una breve descripcion:");
        String descripcion = scanner.InicializarScannerSTR();
        tarea.setDescripcion(descripcion);

        System.out.println("Ingrese una prioridad: 1 baja, 2 media, 3 alta");
        int prioridad = scanner.InicializarScannerINT();
        while (prioridad < 1 || prioridad > 3) {
            System.out.println("La prioridad no está en el rango permitido, por favor, inserte un valor válido");
            System.out.println("Ingrese una prioridad: 1 baja, 2 media, 3 alta");
            prioridad = scanner.InicializarScannerINT();
        }
        tarea.setPrioridad(prioridad);
        tarea.setEstado("Incompleta");

        Desarrollador dev = asignarDesarrolladorATarea(tarea);
        if (dev == null) {
            System.out.println("No hay desarrolladores disponibles.");
        } else {
            tarea.setDev(dev);
            mostrartarea(tarea);
            cola.AcolarPrioridad(tarea, prioridad);
            diccionario.Agregar(tarea.getId(), tarea);
        }
    }

    public static void mostrartarea(Tarea tarea) {
        System.out.println("----------------------<>----------------------");
        Desarrollador d = tarea.getDev();
        System.out.println("El nombre de su tarea es: " + tarea.getNombre());
        System.out.println("Su id es:" + tarea.getId());
        System.out.println("Su descripcion es: " + tarea.getDescripcion());
        System.out.println("Su prioridad es: " + tarea.getPrioridad());
        System.out.println("Su estado es:" + tarea.getEstado());
        System.out.println("Su desarrollador a cargo es: " + d.getNombre());
        System.out.println("ENTER PARA CONTINUAR");
        scanner.InicializarScannerSTR();
        System.out.println("---------------------<>-----------------------");
    }

    // ---------------------------------------------------------------
    // OPCIÓN 3
    // ---------------------------------------------------------------

    public static void eliminarTarea() {
        System.out.println("Ingrese el ID de la tarea que quiera eliminar, 0 para retroceder:");
        int op = scanner.InicializarScannerINT();
        if (op == 0) {
            return;
        } else {
            boolean existe = buscarEnCola(op);
            if (existe) {
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
                System.out.println("Su dev " + dev.getNombre() + " ha sido liberado!!!");
                cambiarDisponibilidad(dev);
            } else {
                aux.AcolarPrioridad(t, t.getPrioridad());
            }
            cola.Desacolar();
        }
        while (!aux.ColaVacia()) {
            cola.AcolarPrioridad(aux.Primero(), aux.Primero().getPrioridad());
            aux.Desacolar();
        }
        return encontrada;
    }

    // ---------------------------------------------------------------
    // OPCIÓN 4
    // ---------------------------------------------------------------

    public static void realizarTarea() {
        if (cola.ColaVacia()) {
            System.out.println("No hay tareas pendientes.");
            return;
        }
        Tarea t = cola.Primero();
        if (t.getEstado().equals("Incompleta")) {
            t.setEstado("En proceso");
            diccionario.Agregar(t.getId(), t);
            System.out.println("La tarea paso a estar: EN PROCESO.");
        } else if (t.getEstado().equals("En proceso")) {
            Desarrollador dev = t.getDev();
            cambiarDisponibilidad(dev);
            cola.Desacolar();
            t.setEstado("completo");
            diccionario.Agregar(t.getId(), t);
            System.out.println("Tarea COMPLETADA con exito.");
        }
    }

    public void TareaCompleta(int id) {
        // ELIMINA TAREA.
        // Invoca a: cambiarDisponibilidad PARA LIBERAR AL DESARROLLADOR.
    }

    // ---------------------------------------------------------------
    // OPCIÓN 6
    // ---------------------------------------------------------------

    public static void AdministrarDevs() {
        while (true) {
            System.out.println("Ingrese 1 si desea ver los devs, 2 si desea agregar, 3 si desea eliminar, otro si desea salir.");
            int op = scanner.InicializarScannerINT();
            if (op == 1) {
                verdevs();
            } else if (op == 2) {
                agregardevs();
            } else if (op == 3) {
                eliminardevs();
            } else {
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
            System.out.println("Nombre:" + d.getNombre());
            System.out.println("Ocupado:" + d.getOcupado());
            System.out.println("DNI: " + d.getDni());
            contador++;
            conjunto.Sacar(d);
            aux.Agregar(d);
        }
        // Restaurar
        while (!aux.ConjuntoVacio()) {
            Desarrollador d = aux.Elegir();
            aux.Sacar(d);
            conjunto.Agregar(d);
        }
    }

    public static void agregardevs() {
        Desarrollador dev = new Desarrollador();
        System.out.println("Ingrese el nombre del desarrollador:");
        String nom = scanner.InicializarScannerSTR();
        System.out.println("Ingrese su dni:");
        int num = scanner.InicializarScannerINT();
        dev.setNombre(nom);
        dev.setDni(num);
        dev.setOcupado(false);
        if (conjunto.Pertenece(dev)) {
            System.out.println("DNI ya ingresado.");
        } else {
            conjunto.Agregar(dev);
            System.out.println("Dev ingresado correctamente!!!");
        }
    }

    public static void eliminardevs() {
        verdevs();
        System.out.println("Ingrese el dni del desarrollador que quiere eliminar, 0 para cancelar:");
        System.out.println("NOTA: DEBE ESTAR DISPONIBLE PARA ELIMINARLO!");
        int dni = scanner.InicializarScannerINT();
        // buscarDisponiblePorDNI reemplaza a BuscarPorDNIDisponibilidad + SacarYNotificar
        if (dni == 0) {
            System.out.println("Operación cancelada.");
            return;}
            if (buscarDisponiblePorDNI(conjunto, dni)) {
                System.out.println("Dev eliminado con exito!!!");
            } else {
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
                tarea.setDev(devEncontrado);
            }
            aux.Agregar(actual);
        }
        while (!aux.ConjuntoVacio()) {
            Desarrollador paraDevolver = aux.Elegir();
            conjunto.Agregar(paraDevolver);
            aux.Sacar(paraDevolver);
        }
        return devEncontrado;
    }

    public static void cambiarDisponibilidad(Desarrollador dev) {
        dev.setOcupado(!dev.getOcupado());
    }

    // ---------------------------------------------------------------
    // OPCIÓN 5
    // ---------------------------------------------------------------

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
        mostrartarea(tarea);
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
                if (tarea.getPrioridad() == nuevaPrioridad) {
                    System.out.println("Esa prioridad ya esta asignada!!");
                } else {
                    tarea.setPrioridad(nuevaPrioridad);
                    prioridadCambiada = true;
                    System.out.println("Prioridad actualizada.");
                }

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
