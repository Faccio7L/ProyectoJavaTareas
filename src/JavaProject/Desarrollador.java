package JavaProject;

public class Desarrollador {
	private String nombre;
    private boolean ocupado; 
    
    
    public void cambiarDisponibilidad(boolean estaOcupado) {
    	//cambia estado sobre si esta ocupado o no. se invoca desde asignar desarrollador a tarea,eliminar tarea o tarea completa
    	
    
    	
    }


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public boolean isOcupado() {
		return ocupado;
	}


	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
}
