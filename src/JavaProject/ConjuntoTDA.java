package JavaProject;
public interface ConjuntoTDA {
	
    void InicializarConjunto();
    void Agregar(Desarrollador d);
    Desarrollador Elegir();
    boolean ConjuntoVacio();
    void Sacar(int dni);
    boolean Pertenece(Desarrollador d);
   
}


