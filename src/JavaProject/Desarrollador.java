package JavaProject;

public class Desarrollador {
	private String nombre;
    private boolean ocupado; 
    private int dni;
    


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	// El GETTER: devuelve el estado actual
    public boolean getOcupado() {
        return ocupado;
    }

    // El SETTER: recibe el nuevo estado y no devuelve nada
    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
}
