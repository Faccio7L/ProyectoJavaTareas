package JavaProject;


public class ColaPrioridad {
    
    //atributos.
    private Tarea[] elementos;
    private int[] prioridades;
    private int indice;

    
    public void inicializarCola() {
        elementos = new Tarea[100];
        prioridades = new int[100];
        indice = 0;
    }

    public void encolar(Tarea t, int prioridad) {
        // FALTA VER LA LOGICA PARA VER COMO ORDENARLO.
        indice++;
    }

    public void desencolar() {
        
        indice--;
    }

    public Tarea verPrimero() {
        
        return elementos[indice - 1];
    }

    public boolean vacia() {
        return (indice == 0);
    }
}
