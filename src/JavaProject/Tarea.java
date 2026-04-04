package JavaProject;



public class Tarea {
	private int id;
    private String nombre;
    private String descripcion;
    private int prioridad; 
    private String estado; 
    private Desarrollador dev;
    private static int contadorId = 0; // static para que pueda ser usado por el constructor.
    
    public Tarea() {
    					// CONSTRUCTOR, SE GENERA con cada objeto tarea.
        contadorId++;         
     	 
     }  
    
     public int getContadorId() {
    	 return contadorId;
     }
    
    public Desarrollador getDev() {
		return dev;
	}

	

    
    
    public void setDev(Desarrollador dev) {
		this.dev = dev;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getPrioridad() {
		return prioridad;
	}


	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

}
