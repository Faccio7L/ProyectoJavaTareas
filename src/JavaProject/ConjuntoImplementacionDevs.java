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

    
    public void Sacar(int dni) {
        int i = 0;
        while (i < cant && devs[i].getDni() != dni) {
            i++;
        }
        
        if (i < cant) {
            devs[i] = devs[cant - 1];
            cant--;
        }
    }
}
