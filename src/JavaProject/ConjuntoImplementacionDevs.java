package JavaProject;

public class ConjuntoImplementacionDevs implements ConjuntoTDA {
    private Desarrollador[] devs;
    private int cant;

    public  void InicializarConjunto() {
        devs = new Desarrollador[100];
        cant = 0;
    }

    public void Agregar(Desarrollador d) {
        
        if (!this.Pertenece(d)) {
            
            if (cant < 100) {
                devs[cant] = d;
                cant++;   
            }
           
            }
        else {
        	System.out.println("EL DNI ya pertence .No se pudo agregar");
  }
    }

    public boolean ConjuntoVacio() {
        return (cant == 0);
    }

    public Desarrollador Elegir() {
        // DEVUELVE DE MANERA ARBITRARIA.
        return devs[cant - 1];
    }

    public boolean Pertenece(Desarrollador d) {
    	//EVALUA EL DNI!!!
        int i = 0;
        while (i < cant && devs[i].getDni() != d.getDni()) {
            i++;
        }
        return (i < cant);
    }

    
    public void SacarPorDNI(int dni) {
    	//SE USA PARA SACAR DEVS. SIN ESTRUCTURA AUXILIAR.
        int i = 0;
        while (i < cant && devs[i].getDni() != dni) { //mientras que i sea menor a la cantidad de desarrolladores y el dni sea distinto al dni pasado como parametro.
            i++;
        }
        
        if (i < cant) { //osea si encontro a i antes de terminar de recorrer todos los devs.
            devs[i] = devs[cant - 1];
            cant--;
            
        }
       
        
    }
    public void Sacar(Desarrollador d) {
    	//SE USA PARA ESTRUCTURAS AUXILIARES.
        int i = 0;
        
        
        while (i < cant && devs[i] != d) {
            i++;
        }
        if (i < cant) {
      devs[i] = devs[cant - 1];
           
            cant--;
      }
    }
    
    public void SacarYNotificar(int dni) {
    	//SE USA NOTIFICAR CAMBIOS EN EL SET, YA QUE PUEDE PASAR COMO NO.
        int i = 0;
        while (i < cant && devs[i].getDni() != dni) { //mientras que i sea menor a la cantidad de desarrolladores y el dni sea distinto al dni pasado como parametro.
            i++;
        }
        
        if (i < cant) { //osea si encontro a i antes de terminar de recorrer todos los devs.
            devs[i] = devs[cant - 1];
            cant--;
            System.out.println("Dev eliminado con exito!!!");
        }
        else {
        	System.out.println("No encontrado.");
        }
        
    }
}
