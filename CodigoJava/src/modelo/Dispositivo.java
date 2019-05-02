
package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dispositivo")
public class Dispositivo {
	/* - - - ATRIBUTOS - - - */
	@Id
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
	public String toString() {
		return getNombre();
	}
	public String toArduino() {
		String estado = getEstado() ? "1" : "0";
		return getNombre().length() < 2 ? "0" + getNombre() + ":" + estado : getNombre() + ":" + estado;
	}
	/* - - - FIN METODOS - - - */
}