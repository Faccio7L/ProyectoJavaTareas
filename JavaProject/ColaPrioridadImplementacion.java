package JavaProject;

public class ColaPrioridadImplementacion implements ColaPrioridadTDA {

    class NodoPrioridad {
        Tarea info;
        int prioridad;
        NodoPrioridad sig;
    }

    private NodoPrioridad mayorPrioridad;

    public void InicializarCola() {
        mayorPrioridad = null;
    }

    public void AcolarPrioridad(Tarea t, int prioridad) {
        NodoPrioridad nuevo = new NodoPrioridad();
        nuevo.info = t;
        nuevo.prioridad = prioridad;

        // si la cola esta vacia o el nuevo tiene mayor prioridad que el primero
        if (mayorPrioridad == null || prioridad > mayorPrioridad.prioridad) {
            nuevo.sig = mayorPrioridad;
            mayorPrioridad = nuevo;
        } else {
            NodoPrioridad actual = mayorPrioridad;
           // si el siguiente existe y su prioridad es mayor o igual avanza
            while (actual.sig != null && actual.sig.prioridad >= prioridad) {
                actual = actual.sig;
            }
            nuevo.sig = actual.sig;
            actual.sig = nuevo;
        }
    }

    public void Desacolar() {
        if (mayorPrioridad != null) {
            mayorPrioridad = mayorPrioridad.sig;
        }
    }

    public boolean ColaVacia() {
        return mayorPrioridad == null;
    }

    public Tarea Primero() {
        return mayorPrioridad.info;
    }

    public int Prioridad() {
        return mayorPrioridad.prioridad;
    }
}
