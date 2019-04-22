package controlador;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import modelo.Dispositivo;
import modelo.Usuario;
import vista.JMenuPrincipal;

public class JPAController {
	/* - - - ATRIBUTOS - - - */
	private static JPAController JPAController = null;
	
	private static final String UNIDAD_DE_PERSISTENCIA = "domoticasa";
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	
	
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONSTRUCTOR - - - */
	private JPAController() {
		try {
			setEntityManagerFactory(Persistence.createEntityManagerFactory(UNIDAD_DE_PERSISTENCIA));
			setEntityManager(getEntityManagerFactory().createEntityManager());
			setEntityTransaction(getEntityManager().getTransaction());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
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
	
	// Metodo para validar usuario introducido en JLogin
	public boolean isUsuario(String alias, String pass) {
		boolean res = false;
		Usuario usr = new Usuario(alias, pass);
		// Usuario es el NOMBRE DE LA CLASE, NO DE LA TABLA
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.alias = :alias");
        q.setParameter("alias", alias);
        try{ 
        	Usuario admin = (Usuario) q.getSingleResult();
	        res = usr.equals(admin) ? true : false;
        } catch(Exception e){ 	          
           System.out.println(e.getMessage());
        }
		return res;
	}
	// Metodo para obetner los dispositivos de la base de datos
	public ArrayList<Dispositivo> getDispositivos() {
		ArrayList<Dispositivo> res = new ArrayList<Dispositivo>();
		
		// Dispositivo es el NOMBRE DE LA CLASE, NO DE LA TABLA
		Query q = em.createQuery("SELECT d FROM Dispositivo d");
		
        try{ 
        	for (Object d : q.getResultList()) {
        		res.add((Dispositivo) d);
        	}
        } catch(Exception e){ 	          
           System.out.println(e.getMessage());
        }
		return res;
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
