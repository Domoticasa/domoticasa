package vista;

import javax.swing.JPanel;

import modelo.Dispositivo;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JToggleButton;

import controlador.JDispositivoListener;

public class JDispositivo extends JPanel {
	
	public Dispositivo dispositivo;
	public JToggleButton tglbtnEstadoDispositivo;
	
	public JDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panelNombreDispositivo = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelNombreDispositivo.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panelNombreDispositivo);
		
		JLabel lblDispositivo = new JLabel("Dispositivo: ");
		panelNombreDispositivo.add(lblDispositivo);
		
		JLabel labelNombreDispositivo = new JLabel(dispositivo.getNombre());
		panelNombreDispositivo.add(labelNombreDispositivo);
		
		JPanel panelEstadoDispositivo = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelEstadoDispositivo.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panelEstadoDispositivo);
		
		JLabel lblEstado = new JLabel("Estado: ");
		panelEstadoDispositivo.add(lblEstado);
		
		tglbtnEstadoDispositivo = new JToggleButton(dispositivo.getEstado() ? "Apagar" : "Encender");
		tglbtnEstadoDispositivo.setSelected(dispositivo.getEstado());
		tglbtnEstadoDispositivo.addActionListener(new JDispositivoListener(this));
		panelEstadoDispositivo.add(tglbtnEstadoDispositivo);
		
	}

}
