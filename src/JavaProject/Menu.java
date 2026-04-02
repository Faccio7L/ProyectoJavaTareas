package JavaProject;



public class Menu {
	
	static GestorTareas gestor = new GestorTareas(); //static para que pueda ser usado  por cualquier metodo .
	static ConjuntoTDA conjunto = new ConjuntoImplementacionDevs();
    
   
    public static void main(String[] args) {
    	
        
    	InicializarMenu();
    }
    
    public static int ObtenerOpcionValida(){ //se invoca desde InicializarMenu.
        while (true){
            try {
            	
                System.out.println("Seleccione una opción");
                int num = scanner.InicializarScannerINT();
                
                if (num>=0 && num<=5){
                    return num;
                }
                else {
                	System.out.println("Valor fuera de rango.");
                }
                
            } catch (Exception e) {
                System.out.println("El caracter ingresado no es un número");
                
            }
        }
    }

    public static void InicializarMenu(){

        String[] opciones = {
    	        "1. Crear Tarea",
    	        "2. Eliminar Tarea",
    	        "3. Actualizar Estado",
    	        "4. Listar Tareas por Estado",
    	        "5.Modificar Desarrolladores.",
    	        "0. Salir"
    	        };

        for (String o: opciones){ 
    		System.out.println(o);
    	}
        
        int seleccion = ObtenerOpcionValida();
        
        if (seleccion >= 1 && seleccion <= 5) {
        	
        	gestor.gestionarTareas(seleccion);
        }
        

        
        else  {//no hace falta un else if por la validacion previa.
	        System.out.println("Hasta luego!!!!");
        }
    }
}
