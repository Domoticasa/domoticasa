package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.JLogin;

public class JLoginListener implements ActionListener {
	
	private JLogin jl;
	
	public JLoginListener(JLogin jl) {
		super();
		this.jl = jl;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String accion = e.getActionCommand();
		
		switch (accion) {
			case "Entrar":
				/* TODO: 
				 * Evaluar las variables String
				 * 	jl.getUsuario(), jl.getPass()
				 * 
				 * Si coinciden con un usario de la base de datos:
				 * 	Sustituir JLogin con JDispositivos en JMenuPrincipal
				 * Si no:
				 * 	Mostrar en la notificacion error de validacion
				*/
			break;
		}
	}

}
