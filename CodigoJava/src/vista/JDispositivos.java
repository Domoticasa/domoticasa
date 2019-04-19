package vista;

import javax.swing.JPanel;

import controlador.JDispositivosListener;

public class JDispositivos extends JPanel {
	/* - - - ATRIBUTOS - - - */
	private JDispositivosListener jdl;
	/* - - - FIN ATRIBUTOS - - - */
	
	
	/* - - - CONTRUCTORES - - - */
	public JDispositivos() {
		jdl = new JDispositivosListener(this);
		
		// TODO: DISEÑO GRAFICO DE JDISPOSITIVOS, TODAS LAS ACCIONES UTILIZAN JDispositivosListener
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
