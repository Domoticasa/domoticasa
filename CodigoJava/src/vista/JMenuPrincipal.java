package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * <p>
 * Ventana principal de la aplicacion Swing.
 * <br>
 * Es un JFrame que contendrá los paneles JLogin y JDispositivos
 * </p>
 * @author WorKeLid
 * @category Vista
 */
public class JMenuPrincipal extends JFrame {
	
	/* - - - ATRIBUTOS - - - */
	public static JPanel menuPane;
	public static JPanel panelPrincipal;
	public static JLabel auxLabel;
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONSTRUCTOR - - - */
	/**
	 * <p>
	 * Constructor de JMenuPrincipal.
	 * <br>
	 * Instancia una aplicacion Swing.
	 * </p>
	 * @author WorKeLid
	 */
	public JMenuPrincipal() {
		
		/* - - - CONFIGURACION - - - */
		setTitle("Domoticasa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 431);
		/* - - - FIN CONFIGURACION - - - */
		
		/* - - - MENU BAR SUPERIOR - - - */
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
			JMenu mnAcercaDe = new JMenu("Acerca de");
			menuBar.add(mnAcercaDe);
				JMenuItem mntmDomoticasa = new JMenuItem("Domoticasa");
				mnAcercaDe.add(mntmDomoticasa);
				
				JMenuItem mntmCodigoEnGithub = new JMenuItem("Codigo en Github");
				mnAcercaDe.add(mntmCodigoEnGithub);
				
				JMenuItem mntmCreditos = new JMenuItem("Creditos");
				mnAcercaDe.add(mntmCreditos);
		/* - - - FIN MENU BAR SUPERIOR - - - */
				
		/* - - - PANEL MENUPRINCIPAL - - - */
		menuPane = new JPanel();
		menuPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(menuPane);
		menuPane.setLayout(new BorderLayout(0, 0));
		/* - - - FIN PANEL MENUPRINCIPAL - - - */
		
		/* - - - PANEL CENTRAL - - - */
		panelPrincipal = new JLogin();
		menuPane.add(panelPrincipal, BorderLayout.CENTER);
		/* - - - FIN PANEL CENTRAL - - - */
		
		/* - - - PANEL INFERIOR AUXILIAR NOTIFICACIONES - - - */
		JPanel auxPane = new JPanel();
		menuPane.add(auxPane, BorderLayout.SOUTH);
		auxPane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
			auxLabel = new JLabel("");
			auxPane.add(auxLabel);
		/* - - - FIN PANEL INFERIOR AUXILIAR NOTIFICACIONES - - - */
	}
	/* - - - FIN CONSTRUCTOR - - - */
	
	/* - - - GETS - - - */

	/* - - - FIN GETS - - - */
	
	/* - - - SETS - - - */

	/* - - - FIN SETS - - - */
	
	/* - - - METODOS - - - */
	    
	/* - - - FIN METODOS - - - */
}