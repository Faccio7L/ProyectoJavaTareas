package JavaProject;
public interface ConjuntoTDA {
	
    void InicializarConjunto();
    void Agregar(Desarrollador d);
    Desarrollador Elegir();
    boolean ConjuntoVacio();
    void Sacar(Desarrollador d);
    void SacarYNotificar(int dni);
    void SacarPorDNI(int dni);
    boolean Pertenece(Desarrollador d);
    boolean BuscarPorDNIDisponibilidad(int dni);
   
}


