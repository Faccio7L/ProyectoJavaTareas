package JavaProject;

public class ConjuntoImplementacionDevs implements ConjuntoTDA {
    private Desarrollador[] devs;
    private int cant;

    public  void InicializarConjunto() {
        devs = new Desarrollador[100];
        cant = 0;
    }

    public void Agregar(Desarrollador d) {
        // Solo agregamos si el desarrollador no existe ya en el conjunto
        if (!this.Pertenece(d)) {
            devs[cant] = d;
            cant++;
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
        int i = 0;
        while (i < cant && !devs[i].equals(d)) {
            i++;
        }
        return (i < cant);
    }

    public void Sacar(Desarrollador d) {
        int i = 0;
        while (i < cant && !devs[i].equals(d)) {
            i++;
        }

        if (i < cant) {
            // PARA EVITAR HUECOS EN EL ARRAY
            devs[i] = devs[cant - 1];
            devs[cant - 1] = null; 
            cant--;
        }
    }
}
