package JavaProject;

public interface ConjuntoTDA {

    void InicializarConjunto();
    /**
     * tiene que estar inicializada
     */

    void Agregar(Desarrollador d);
    /**
     * tiene que estar inicializada
     */

    boolean Pertenece(Desarrollador d);
    /**
     * tiene que estar inicializada
     */

    void Sacar(Desarrollador d);
    /**
     * no tiene que estar vacío
     */

    Desarrollador Elegir();
    /**
     * tiene que estar inicializada
     */

    boolean ConjuntoVacio();
}
