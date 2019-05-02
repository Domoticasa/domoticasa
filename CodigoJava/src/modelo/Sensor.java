package modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sensor")
public class Sensor {
	/* - - - ATRIBUTOS - - - */
	@Id
	private String nombre;
	private int valor;
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONSTRUCTORES - - - */
	public Sensor() {
		
	}
	public Sensor(String nombre, int valor) {
		setNombre(nombre);
		setValor(valor);
	}
	public Sensor(String sensor) {
		String[] sensorString = sensor.split(":");
		setNombre(sensorString[0]);
		setValor(Integer.parseInt(sensorString[1]));
	}
	/* - - - FIN CONSTRUCTORES - - - */
	
	/* - - - GETS - - - */
	public String getNombre() {
		return this.nombre;
	}
	public int getValor() {
		return this.valor;
	}
	/* - - - FIN GETS - - - */
	
	/* - - - SETS - - - */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	/* - - - FIN SETS - - - */
	
	/* - - - METODOS - - - */
	public boolean equals(Sensor sensor) {
		return (this.getNombre().equals(sensor.getNombre()) && 
				this.getValor() == sensor.getValor());
	}
	public String toString() {
		return getNombre();
	}
	/* - - - FIN METODOS - - - */
}
