package JavaProject;



public class Menu {
	
	GestorTareas gestor = new GestorTareas(); //static para que pueda ser usado  por cualquier metodo .
	ConjuntoTDA conjunto = new ConjuntoImplementacionDevs();
    int InApp;
    
    public int ObtenerOpcionValida(){ //se invoca desde InicializarMenu.
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

    public Menu() throws Exception{
        InApp=1;
        System.out.println((1));

    }

    public void InicializarMenu(){
    	while (InApp==1) {
            String[] opciones={
                    "1. Crear Tarea",
                    "2. Ver Tarea por prioridad",
                    "3. Eliminar Tarea",                //hacer
                    "4. Actualizar Estado",             //hacer
                    "5. Listar Tareas por Estado",      //hacer        
                    "6. Modificar Desarrolladores.",
                    "0. Salir"
                    };

            for (String o: opciones){ 
                System.out.println(o);
            }
            
            int seleccion = ObtenerOpcionValida();
            
            if (seleccion >= 1 && seleccion <= 6){
                GestorTareas.gestionarTareas(seleccion);
            }
            else{
                InApp=0;
            }
        }
    }
}