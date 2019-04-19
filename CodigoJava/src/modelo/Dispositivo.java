package modelo;

public class Dispositivo {
	/* - - - ATRIBUTOS - - - */
	private String nombre;
	private boolean estado;
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONSTRUCTORES - - - */
	public Dispositivo() {
		
	}
	public Dispositivo(String nombre, boolean estado) {
		setNombre(nombre);
		setEstado(estado);
	}
	/* - - - FIN CONSTRUCTORES - - - */
	
	/* - - - GETS - - - */
	public String getNombre() {
		return this.nombre;
	}
	public boolean getEstado() {
		return this.estado;
	}
	/* - - - FIN GETS - - - */
	
	/* - - - SETS - - - */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	/* - - - FIN SETS - - - */
	
	/* - - - METODOS - - - */
	public boolean equals(Dispositivo dispositivo) {
		return (this.getNombre().equals(dispositivo.getNombre()) && 
				this.getEstado() == dispositivo.getEstado());
	}
	/* - - - FIN METODOS - - - */
}