package JavaProject;

public interface ConjuntoTDA {

    void InicializarConjunto();
    /**
     * __tiene__ __que__ __estar__ __inicializada__
     */

    void Agregar(Desarrollador d);
    /**
     * __tiene__ __que__ __estar__ __inicializada__
     */

    boolean Pertenece(Desarrollador d);
    /**
     * __tiene__ __que__ __estar__ __inicializada__
     */

    void Sacar(Desarrollador d);
    /**
     * no __tiene__ __que__ __estar__ __vacío__
     */

    Desarrollador Elegir();
    /**
     * __tiene__ __que__ __estar__ __inicializada__
     */

    boolean ConjuntoVacio();
}
