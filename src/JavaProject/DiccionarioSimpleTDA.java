package JavaProject;

public interface DiccionarioSimpleTDA {

    /**
     * Inicializa el diccionario.
     */
    public void InicializarDiccionario();

    /**
     * Agrega una tarea al diccionario usando su ID como clave.
     * Si la clave ya existe, reemplaza el valor.
     * Precondicion: inicializado.
     */
    public void Agregar(int clave, Tarea valor);

    /**
     * Elimina la entrada con la clave indicada.
     * Precondicion: inicializado.
     */
    public void Eliminar(int clave);

    /**
     * Recupera la tarea asociada a la clave.
     * Precondicion: inicializado, no vacio, clave existente.
     */
    public Tarea Recuperar(int clave);

    /**
     * Devuelve las claves del diccionario como un arreglo de enteros.
     * Precondicion: inicializado.
     */
    public int[] ObtenerClaves();

    /**
     * Verifica si existe una clave en el diccionario.
     * Precondicion: inicializado.
     */
    public boolean ExisteClave(int clave);

    /**
     * Verifica si el diccionario esta vacio.
     * Precondicion: inicializado.
     */
    public boolean DiccionarioVacio();
}