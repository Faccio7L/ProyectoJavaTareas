package JavaProject;

public class DiccionarioSimpleImplementacion implements DiccionarioSimpleTDA {

    private int[] claves;
    private Tarea[] valores;
    private int cant;

    public void InicializarDiccionario() {
        claves = new int[500];
        valores = new Tarea[500];
        cant = 0;
    }

    public void Agregar(int clave, Tarea valor) {
        // Si la clave ya existe, reemplaza el valor
        if (cant < 500) {
            int i = indiceDeClave(clave);
            if (i >= 0) {
                valores[i] = valor;
            } else {
                // Clave nueva
                claves[cant] = clave;
                valores[cant] = valor;
                cant++;
            }
        }
        else{System.out.println("LLego al limite de tareas!!!");}
    }


    public void Eliminar(int clave) {
        int i = indiceDeClave(clave);
        if (i >= 0) {
            // Mueve el ultimo elemento al lugar del eliminado
            claves[i] = claves[cant - 1];
            valores[i] = valores[cant - 1];
            cant--;
        }
    }

    public Tarea Recuperar(int clave) {
        int i = indiceDeClave(clave);
        if (i >= 0) {
            return valores[i];
        }
        return null;
    }

    public int[] ObtenerClaves() {
        int[] resultado = new int[cant];
        for (int i = 0; i < cant; i++) {
            resultado[i] = claves[i];
        }
        return resultado;
    }





    // Metodo auxiliar privado: busca el indice de una clave, devuelve -1 si no existe
    private int indiceDeClave(int clave) {
        int i = 0;
        while (i < cant && claves[i] != clave) {
            i++;
        }
        if (i < cant) {
            return i;
        }
        return -1;
    }
}