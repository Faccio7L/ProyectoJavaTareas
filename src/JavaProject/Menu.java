package JavaProject;

public class Menu {
    
    static GestorTareas gestor = new GestorTareas();  //static para que pueda ser usado  por main.
	
    private int ObtenerOpcionValida(){
        while (true){
            try {
                System.out.println("Seleccione una opción");
                int num = scanner.InicializarScanner();
                
                if (num>=1 && num<=5){
                    return num;
                }
                
            } catch (Exception e) {
                System.out.println("El caracter ingresado no es un número");
            }
        }
    }

    public void InicializarMenu(){

        String[] opciones = {
    	        "1. Crear Tarea",
    	        "2. Eliminar Tarea",
    	        "3. Actualizar Estado",
    	        "4. Listar Tareas por Estado",
    	        "5. Salir"
    	        };

        for (String o: opciones){ 
    		System.out.println(o);
    	}
        
        int seleccion = ObtenerOpcionValida();

        if (seleccion==1) {
			gestor.gestionarTareas(1);
    	}
    	if (seleccion==2) {
			gestor.gestionarTareas(2);
    	}
    	if (seleccion==3) {
            gestor.gestionarTareas(3);
    	}
    	if (seleccion==4) {
			gestor.gestionarTareas(4);
	    }
    	if (seleccion==5) {
	        System.out.println("Hasta luego!!!!");
        }
    }
}
