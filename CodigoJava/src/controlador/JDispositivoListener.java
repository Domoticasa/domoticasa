package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.JDispositivo;
import vista.JDispositivos;
import vista.JMenuPrincipal;
/**
 * <p>
 * JDispositivoListener es la clase encargada d
 * </p>
 * @author WorKeLid
 * @category Controlador
 */
public class JDispositivoListener implements ActionListener {
	/* - - - ATRIBUTOS - - - */
	private JPAController jpa;
	private JDispositivo jd;
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONTRUCTORES - - - */
	public JDispositivoListener(JDispositivo jd) {
		setJPAController(JPAController.getInstance());
		setJDispositivo(jd);
	}
	/* - - - FIN CONTRUCTORES - - - */
	
	/* - - - GETS - - - */
	
	/* - - - FIN GETS - - - */
	
	/* - - - SETS - - - */
	public void setJPAController(JPAController jpa) {
		this.jpa = jpa;
	}
	public void setJDispositivo(JDispositivo jd) {
		this.jd = jd;
	}
	/* - - - FIN SETS - - - */
	
	/* - - - METODOS - - - */
	public void actionPerformed(ActionEvent e) {
		String accion = e.getActionCommand();
		switch (accion) {
			case "Apagar":
				JMenuPrincipal.auxLabel.setText("Apagando dispositivo");
				
				jpa.getEntityManager().merge(jd.dispositivo);
				jpa.getEntityTransaction().begin();
				jd.dispositivo.setEstado(false);
				jpa.getEntityTransaction().commit();
				
				jd.tglbtnEstadoDispositivo.setText("Encender");
				jd.revalidate();
			break;
			case "Encender":
				JMenuPrincipal.auxLabel.setText("Encendiendo dispositivo");
				
				jpa.getEntityManager().merge(jd.dispositivo);
				jpa.getEntityTransaction().begin();
				jd.dispositivo.setEstado(true);
				jpa.getEntityTransaction().commit();
				
				jd.tglbtnEstadoDispositivo.setText("Apagar");
				jd.revalidate();
			break;
		}
	}
	/* - - - FIN METODOS - - - */
}
