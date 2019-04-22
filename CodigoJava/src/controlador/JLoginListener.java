package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import vista.JDispositivos;
import vista.JLogin;
import vista.JMenuPrincipal;

public class JLoginListener implements ActionListener {
	
	private JLogin jl;
	private JPAController jpac;
	
	public JLoginListener(JLogin jl) {
		super();
		this.jl = jl;
		this.jpac = JPAController.getInstance();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String accion = e.getActionCommand();
		
		switch (accion) {
			case "Entrar":
				if (jpac.isUsuario(jl.getAlias(), jl.getPass())) {
					JMenuPrincipal.auxLabel.setText("Inicion de sesion correcto");
					
					JMenuPrincipal.panelPrincipal.removeAll();
					JMenuPrincipal.panelPrincipal.add(new JDispositivos(jpac.getDispositivos()));
					JMenuPrincipal.panelPrincipal.revalidate();
					
				} else {
					JMenuPrincipal.auxLabel.setText("Fallo al iniciar sesion");
				}
				JMenuPrincipal.auxLabel.revalidate();
			break;
		}
	}

}
