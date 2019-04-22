package vista;

import javax.swing.JPanel;

import controlador.JDispositivosListener;
import modelo.Dispositivo;

import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class JDispositivos extends JPanel {
	/* - - - ATRIBUTOS - - - */
	private JDispositivosListener jdl;
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONTRUCTORES - - - */
	public JDispositivos(ArrayList<Dispositivo> dispositivos) {
		
		jdl = new JDispositivosListener(this);
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelDispositivos = new JPanel();
		add(panelDispositivos, BorderLayout.NORTH);
		panelDispositivos.setLayout(new BoxLayout(panelDispositivos, BoxLayout.Y_AXIS));
		for (Dispositivo d : dispositivos) {
			panelDispositivos.add(new JDispositivo(d));
		}
		JPanel panelOpciones = new JPanel();
		add(panelOpciones, BorderLayout.SOUTH);
		
		JButton btnNuevoDispositivo = new JButton("Nuevo Dispositivo");
		panelOpciones.add(btnNuevoDispositivo);
		
	}
	/* - - - FIN CONSTRUCTORES - - - */
	
	/* - - - GETS - - - */
	public JDispositivosListener getJDispositivoListener() {
		return this.jdl;
	}
	/* - - - FIN GETS - - - */
	
	/* - - - SETS - - - */
	public void setJDispositivosListener(JDispositivosListener jdl) {
		this.jdl = jdl;
	}
	/* - - - FIN SETS - - - */
	
	/* - - - METODOS - - - */
	
	/* - - - FIN METODOS - - - */
}
