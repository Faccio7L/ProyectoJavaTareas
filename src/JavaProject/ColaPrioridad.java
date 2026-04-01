package JavaProject;


interface ColaPrioridadTDA {
    void inicializarCola();
    void encolar(Tarea t, int prioridad);
    void desencolar();
    Tarea verPrimero();
    boolean vacia();
    int prioridad();
    //TIENE QUE ESTAR EN OTRA CLASE LA INTERFAZ!!! 
}

public class ColaPrioridad implements ColaPrioridadTDA {

    
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
    if (elementos.length <= 99) {
     int pos = indice;
    for (int i = 0; i < indice; i++) {
        if (prioridad > prioridades[i]) {
            pos = i;
            i = indice;
        }
    }
    for (int i = indice; i > pos; i--) {
        elementos[i] = elementos[i - 1];
        prioridades[i] = prioridades[i - 1];
    }
    elementos[pos] = t;
    prioridades[pos] = prioridad; 
        indice++;
    }
    
    else {
    	System.out.println("Has llegado al limite de tareas.");
    }
    }
    public void desencolar() {
        for(int i = 0; i < indice; i++) {
            elementos[i] = elementos[i + 1];
            prioridades[i] = prioridades[i + 1];
        }
        indice--;
    }

    public Tarea verPrimero() {
        
        return elementos[indice - 1];
    }

    public boolean vacia() {
        return (indice == 0);
    }
    public int prioridad() {
		return prioridades[0];
	}
}
