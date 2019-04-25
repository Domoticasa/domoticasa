package vista;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.JLoginListener;

import javax.swing.JButton;

/**
 * <p>
 * Panel que ofrece la entrada de un alias y una contraseña
 * </p>
 * @author WorKeLid
 * @category Vista
 */
public class JLogin extends JPanel {
	
	/* - - - ATRIBUTOS - - - */
	private JTextField tfAlias;
	private JTextField tfPass;
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONTRUCTOR - - - */
	/**
	 * <p>
	 * Instancia un panel desde el que introducir un alias y una contraseña
	 * </p>
	 * @author WorKeLid
	 */
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
			tfAlias = new JTextField();
			panelAlias.add(tfAlias);
			tfAlias.setColumns(10);
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
			btnEntrar.addActionListener(new JLoginListener(this));
			panelEntrar.add(btnEntrar);
		/* - - - FIN BOTON ENTRAR - - - */
		
		/* - - - FIN PANEL LOGIN - - - */
	}
	/* - - - FIN CONTRUCTOR - - - */
	
	/* - - - GETS - - - */
	// TODO: Finalizar Javadocs
	/**
	 * <p>
	 *
	 * </p>
	 * @return
	 * @author WorKeLid
	 */
	public String getAlias() {
		return this.tfAlias.getText();
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