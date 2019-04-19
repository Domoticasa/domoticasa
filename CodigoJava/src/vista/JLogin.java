package vista;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class JLogin extends JPanel {
	
	/* - - - ATRIBUTOS - - - */
	private JTextField tfUsuario;
	private JTextField tfPass;
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONTRUCTOR - - - */
	public JLogin() {
		/* - - -CONFIGURACION - - - */
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/* - - - FIN CONFIGURACION - - - */
		
		/* - - - PANEL LOGIN - - - */
		
		/* - - - CAMPO USUARIO - - - */
		JPanel panelAlias = new JPanel();
		add(panelAlias);
		
			JLabel lblUsuario = new JLabel("Usuario:");
			panelAlias.add(lblUsuario);
			
			tfUsuario = new JTextField();
			panelAlias.add(tfUsuario);
			tfUsuario.setColumns(10);
		/* - - - FIN CAMPO USUARIO - - - */
		
		
		/* - - - CAMPO CONTRASEÑA - - - */
		JPanel panelPass = new JPanel();
		add(panelPass);
		
			JLabel lblPass = new JLabel("Contrase\u00F1a: ");
			panelPass.add(lblPass);
			
			tfPass = new JTextField();
			panelPass.add(tfPass);
			tfPass.setColumns(10);
		/* - - - FIN CAMPO CONTRASEÑA - - - */
		
		/* - - - BOTON ENTRAR - - - */
		JPanel panelEntrar = new JPanel();
		add(panelEntrar);
		
			JButton btnEntrar = new JButton("Entrar");
			// TODO: Añadir JLoginListener al boton btnEntrar
			panelEntrar.add(btnEntrar);
		/* - - - FIN BOTON ENTRAR - - - */
		
		/* - - - FIN PANEL LOGIN - - - */
	}
	/* - - - FIN CONTRUCTOR - - - */
	
	/* - - - GETS - - - */
	public String getUsuario() {
		return this.tfUsuario.getText();
	}
	public String getPass() {
		return this.tfPass.getText();
	}
	/* - - - FIN GETS - - - */
	
	/* - - - SETS - - - */
	
	/* - - - FIN SETS - - - */
	
	/* - - - METODOS - - - */
	
	/* - - - FIN METODOS - - - */
}