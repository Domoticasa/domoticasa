package controlador;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import vista.JMenuPrincipal;

public class JPAController {
	/* - - - ATRIBUTOS - - - */
	private static JPAController JPAController = null;
	
	private static final String BASE_DE_DATOS = "domoticasa";
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONSTRUCTOR - - - */
	private JPAController() {
		setEntityManagerFactory(Persistence.createEntityManagerFactory(BASE_DE_DATOS));
		setEntityManager(getEntityManagerFactory().createEntityManager());
		setEntityTransaction(getEntityManager().getTransaction());
	}
	/* - - - FIN CONSTRUCTOR - - - */
	
	/* - - - GETS - - - */
	public EntityManagerFactory getEntityManagerFactory() {
		return this.emf;
	}
	public EntityManager getEntityManager() {
		return this.em;
	}
	public EntityTransaction getEntityTransaction() {
		return this.tx;
	}
	/* - - - FIN GETS - - - */
	
	/* - - - SETS - - - */
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	public void setEntityTransaction(EntityTransaction tx) {
		this.tx = tx;
	}
	/* - - - FIN SETS - - - */
	
	/* - - - METODOS - - - */
	
	// Metodo estatico para crear una instancia singleton, usar este metodo para usar JPAController
    public static JPAController getInstance() { 
        if (JPAController == null) 
        	JPAController = new JPAController(); 
        return JPAController; 
    }
    
    // Metodo para terminar la conexion con MySQL
	public void close() {
		getEntityManager().close();
		getEntityManagerFactory().close();
	}
	/* - - - FIN METODOS - - - */
	
	/* - - - PUNTO DE ENTRADA DE LA APLICACION - - - */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenuPrincipal frame = new JMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/* - - - FIN PUNTO DE ENTRADA DE LA APLICACION - - - */
}
