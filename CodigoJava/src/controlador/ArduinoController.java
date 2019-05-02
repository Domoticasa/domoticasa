package controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import modelo.Dispositivo;
import modelo.Sensor;

/**
 * 
 * <p>
 * ArduinoControler es una clase singleton encargada de la comunicacion con Arduino
 * <br>
 * Toda clase que desee actuar sobre Arduino debera utilizar esta clase.
 * </p>
 * <p>
 * Para usar ArduinoController se utiliza su método estatico getInstance()
 * </p>
 * @author WorKeLid
 * @category Controlador
 */
public class ArduinoController implements SerialPortEventListener {

	/* - - - ATRIBUTOS - - - */
	private static ArduinoController ac = null;
	//private JPAController jpac;
	private SerialPort serialPort;
	private static final String PORT_NAMES[] = { 
			"/dev/tty.usbserial-A9007UX1", // Mac OS X
                        "/dev/ttyACM0", // Raspberry Pi
			"/dev/ttyUSB0", // Linux
			"COM3", // Windows
	};
	/**
	* Un BufferedReader que lee de un InputStreamReader.
	* <br>
	* Informacion procedente de Arduino de tipo String.
	* <br>
	* Convierte Bytes en caracteres. 
	*/
	private BufferedReader input;
	/** 
	 * Informacion para enviar a Arduino en String.
	*/
	private OutputStream output;
	/** Milliseconds to block while waiting for port open */
	private static final int TIME_OUT = 2000;
	/** Default bits per second for COM port. */
	private static final int DATA_RATE = 9600;
	
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONSTRUCTOR - - - */
	private ArduinoController() {
		//this.jpac = JPAController.getInstance();
		try {
			CommPortIdentifier portId = null;
			Enumeration portEnum = CommPortIdentifier.getPortIdentifiers();

			//First, Find an instance of serial port as set in PORT_NAMES.
			while (portEnum.hasMoreElements()) {
				CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();
				for (String portName : PORT_NAMES) {
					if (currPortId.getName().equals(portName)) {
						portId = currPortId;
						break;
					}
				}
			}
			if (portId == null) {
				System.out.println("Could not find COM port.");
				return;
			}
			try {
				// open serial port, and use class name for the appName.
				serialPort = (SerialPort) portId.open(this.getClass().getName(),
						TIME_OUT);

				// set port parameters
				serialPort.setSerialPortParams(DATA_RATE,
						SerialPort.DATABITS_8,
						SerialPort.STOPBITS_1,
						SerialPort.PARITY_NONE);

				// open the streams
				input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
				output = serialPort.getOutputStream();

				// add event listeners
				serialPort.addEventListener(this);
				serialPort.notifyOnDataAvailable(true);
				
			} catch (Exception e) {
				System.err.println(e.toString());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/* - - - FIN CONSTRUCTOR - - - */
	
	/* - - - GETS - - - */
	
	/* - - - FIN GETS - - - */
	
	/* - - - SETS - - - */
	
	/* - - - FIN SETS - - - */
	
	/* - - - METODOS - - - */
	/**
	 * <p>
	 * Metodo estatico para crear una instancia singleton, usar este metodo para usar ArduinoController
	 * </p>
	 * @return El singleton JPAController
	 * @author WorKeLid
	 */
    public static ArduinoController getInstance() { 
        if (ac == null) 
        	ac = new ArduinoController(); 
        return ac; 
    }
    /**
	 * Handle an event on the serial port. Read the data and print it.
	 * <br>
	 * Se ejecuta cada vez que Arduino envia algo.
	 */
	public synchronized void serialEvent(SerialPortEvent oEvent) {
		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine = input.readLine();
				
				if (inputLine.startsWith("listo")) {
					refrescar();
				}
				
				if (inputLine.startsWith("A")) {
					String[] sensoresString = inputLine.split(" ");
					ArrayList<Sensor> sensores = new ArrayList<Sensor>();
					
					for (String s : sensoresString) {
						sensores.add(new Sensor(s));
					}
					JPAController.getInstance().UpdateSensores(sensores);
					
				}
				System.out.println("Que recibe java: " + inputLine);
			} catch (Exception e) {
				
			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
	}
	/**
	 * El método refrescar envia a Arduino el estado de los dispositivos
	 * en la base de datos
	 * @author WorKeLid
	 */
	public synchronized void refrescar() {
		try {
			ArrayList<Dispositivo> dispositivos = JPAController.getInstance().getDispositivos();
			String output = "";
			for (Dispositivo d : dispositivos) {
				output = output + d.toArduino() + " ";
			}
			
			System.out.println("Que envia java: " + output);
			
			this.output.write(output.getBytes());
			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
    /**
	 * This should be called when you stop using the port.
	 * This will prevent port locking on platforms like Linux.
	 */
	public synchronized void close() {
		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}
	/* - - - METODOS - - - */	
}