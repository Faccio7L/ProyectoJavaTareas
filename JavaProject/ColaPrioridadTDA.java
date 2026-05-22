package JavaProject;

public interface ColaPrioridadTDA{
	
	void InicializarCola();
	void AcolarPrioridad(Tarea t, int prioridad);
	void Desacolar();
	boolean ColaVacia();
	Tarea Primero();
	int Prioridad();
	
}
