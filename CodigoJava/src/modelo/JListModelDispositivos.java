package modelo;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class JListModelDispositivos extends AbstractListModel<Dispositivo>{
	/* - - - ATRIBUTOS - - - */
	private ArrayList<Dispositivo> dispositivos;
	/* - - - FIN ATRIBUTOS - - - */
	
	public JListModelDispositivos() {
		// TODO INICIALIZAR EL ARRAYLIST dispositivos CON LOS DISPOSITIVOS LEIDOS DE LA BASE DE DATOS
	}
	
	public Dispositivo getElementAt(int arg0) {
		// TODO DEVOLVER EL ELEMENTO NUMERO arg0 DEL MODELO LISTA
		return null;
	}

	public int getSize() {
		// TODO DEVOLVER EL TAMAÑO DEL MODELO LISTA
		return 0;
	}
}