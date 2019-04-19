package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.JDispositivos;

public class JDispositivosListener implements ActionListener{
	/* - - - ATRIBUTOS - - - */
	private JDispositivos jd;
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONTRUCTORES - - - */
	public JDispositivosListener(JDispositivos jd) {
		setJDispositivos(jd);
	}
	/* - - - FIN CONTRUCTORES - - - */
	
	/* - - - GETS - - - */
	public JDispositivos getJDispositivos() {
		return this.jd;
	}
	/* - - - FIN GETS - - - */
	
	/* - - - SETS - - - */
	public void setJDispositivos(JDispositivos jd) {
		this.jd = jd;
	}
	/* - - - FIN SETS - - - */
	
	/* - - - METODOS - - - */
	public void actionPerformed(ActionEvent e) {
		// TODO: CONTROL DE LAS ACCIONES REALIZADAS EN JDISPOSITIVOS
	}
	/* - - - FIN METODOS - - - */
}
