package controlador;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.Dispositivo;
import modelo.Usuario;
import vista.JMenuPrincipal;

/**
 * 
 * <p>
 * JPAController es una clase singleton encargada de actuar sobre la base de datos
 * y ofrecer informacion sobre ella a las vistas de Swing y al Arduino.
 * <br>
 * Toda clase que desee actuar sobre la base de datos debera utilizar esta clase.
 * </p>
 * <p>
 * Para usar JPAController se utiliza su método estatico getInstance()
 * </p>
 * @author WorKeLid
 * @category Controlador
 */
public class JPAController implements Runnable {
	
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
			
			new Thread(this).start();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/* - - - FIN CONSTRUCTOR - - - */
	
	/* - - - GETS - - - */
	/**
	 * <p>
	 * Devuleve la factoria de los gestores de entidades
	 * </p>
	 * @return El EntityManagerFactory usado por JPAController
	 * @author WorKeLid
	 */
	public EntityManagerFactory getEntityManagerFactory() {
		return this.emf;
	}
	/**
	 * <p>
	 * Devuleve el gestor de entidades usado para la gestion de la base de datos
	 * </p>
	 * @return El EntityManager usado por JPAController
	 * @author WorKeLid
	 */
	public EntityManager getEntityManager() {
		return this.em;
	}
	/**
	 * <p>
	 * Devuleve la transaccion que utiliza el gestor de entidades para persistir los cambios
	 * </p>
	 * @return El EntityTransaccion usado por JPAController
	 * @author WorKeLid
	 */
	public EntityTransaction getEntityTransaction() {
		return this.tx;
	}
	/* - - - FIN GETS - - - */
	
	/* - - - SETS - - - */
	/**
	 * <p>
	 * Establece la factoria de los gestores de entidades
	 * </p>
	 * @param emf El nuevo EntityManagerFactory
	 * @author WorKeLid
	 */
	public void setEntityManagerFactory(EntityManagerFactory emf) {
		this.emf = emf;
	}
	/**
	 * <p>
	 * Establece el gestor de entidades
	 * </p>
	 * @param em El nuevo EntityManager
	 * @author WorKeLid
	 */
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	/**
	 * <p>
	 * Establece la transaccion del gestor de entidades
	 * </p>
	 * @param tx El nuevo EntityTransaction
	 * @author WorKeLid
	 */
	public void setEntityTransaction(EntityTransaction tx) {
		this.tx = tx;
	}
	/* - - - FIN SETS - - - */
	
	/* - - - METODOS - - - */
	
	// 
	/**
	 * <p>
	 * Metodo estatico para crear una instancia singleton, usar este metodo para usar JPAController
	 * </p>
	 * @return El singleton JPAController
	 * @author WorKeLid
	 */
    public static JPAController getInstance() { 
        if (JPAController == null) 
        	JPAController = new JPAController(); 
        return JPAController; 
    }
    /**
     * <p>
     * Metodo para finalizar la conexion con MySQL
     * </p>
     * @author WorKeLid
     */
	public void close() {
		getEntityManager().close();
		getEntityManagerFactory().close();
	}
	/**
	 * <p>
	 * Comprueba si los valores introducidos corresponden a un Usuario en la base
	 * de datos.
	 * </p>
	 * @param alias El nombre del usuario a validar
	 * @param pass La contraseña del usuario a validar
	 * @return Si el usuario existe en la base de datos
	 * @author WorKeLid
	 */
	public boolean isUsuario(String alias, String pass) {
		boolean res = false;
		Usuario usr = new Usuario(alias, pass);
		
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.alias = :alias");
        q.setParameter("alias", alias);
        try{ 
        	Usuario admin = (Usuario) q.getSingleResult();
	        res = usr.equals(admin) ? true : false;
        } catch(Exception e){ 	   
        	// TODO: Mostrar mensaje en etiqueta auxiliar
        	System.out.println(e.getMessage());
        }
		return res;
	}
	/**
	 * <p>
	 * Devuelve todos los usuarios de la base de datos
	 * </p>
	 * @return Un ArrayList<Usuario> con los usuarios
	 * @author WorKeLid
	 */
	public ArrayList<Usuario> getUsuarios() {
		ArrayList<Usuario> res = new ArrayList<Usuario>();
		
		Query q = em.createQuery("SELECT u FROM Usuario u");
        try{ 
        	for (Object d : q.getResultList()) {
        		res.add((Usuario) d);
        	}
        } catch(Exception e){ 	          
        	// TODO: Mostrar mensaje en etiqueta auxiliar
        	System.out.println(e.getMessage());
        }
		return res;
	}
	/**
	 * <p>
	 * Devuelve todos los dispositivos de la base de datos
	 * </p>
	 * @return Un ArrayList<Dispositivo> con los dispositivos
	 * @author WorKeLid
	 */
	public ArrayList<Dispositivo> getDispositivos() {
		ArrayList<Dispositivo> res = new ArrayList<Dispositivo>();
		
		Query q = em.createQuery("SELECT d FROM Dispositivo d");
        try{ 
        	for (Object d : q.getResultList()) {
        		res.add((Dispositivo) d);
        	}
        } catch(Exception e){ 	          
        	// TODO: Mostrar mensaje en etiqueta auxiliar
        	System.out.println(e.getMessage());
        }
		return res;
	}
	/* - - - FIN METODOS - - - */
	
	/* - - - HILO - - - */
	public void run() {
		while(true) {
			System.out.println("hola");
		}
	}
	/* - - - FIN HILO - - - */
	
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