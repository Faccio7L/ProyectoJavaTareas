package JavaProject;

public class ConjuntoImplementacionDevs implements ConjuntoTDA {

    private Desarrollador[] devs;
    private int cant;

    

    public void InicializarConjunto() {
        devs = new Desarrollador[100];
        cant = 0;
    }

    public void Agregar(Desarrollador d) {
        if (!this.Pertenece(d)) {
            if (cant < 100) {
                devs[cant] = d;
                cant++;
            }
        } else {
            System.out.println("El DNI ya pertenece. No se pudo agregar.");
        }
    }

    public boolean Pertenece(Desarrollador d) {
        // Evalúa por DNI
        int i = 0;
        while (i < cant && devs[i].getDni() != d.getDni()) {
            i++;
        }
        return i < cant;
    }

    public void Sacar(Desarrollador d) {
        int i = 0;
        while (i < cant && devs[i].getDni() != d.getDni()) {
            i++;
        }
        if (i < cant) {
            devs[i] = devs[cant - 1];
            cant--;
        }
    }

    public Desarrollador Elegir() {
        return devs[cant - 1];
    }

    public boolean ConjuntoVacio() {
        return cant == 0;
    }
}