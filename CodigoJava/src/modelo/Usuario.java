package modelo;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	/* - - - ATRIBUTOS - - - */
	@Id
	private String alias;
	private String pass;
	/* - - - FIN ATRIBUTOS - - - */
	
	/* - - - CONSTRUCTORES - - - */
	public Usuario() {
		
	}
	public Usuario(String alias, String pass) {
		setAlias(alias);
		setPass(pass);
	}
	/* - - - FIN CONSTRUCTORES - - - */
	
	/* - - - GETS - - - */
	public String getAlias() {
		return this.alias;
	}
	public String getPass() {
		return this.pass;
	}
	/* - - - FIN GETS - - - */
	
	/* - - - SETS - - - */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	/* - - - FIN SETS - - - */
	
	/* - - - METODOS - - - */
	public boolean equals(Usuario usuario) {
		boolean res = false;
		if (usuario instanceof Usuario) {
			res = this.getAlias().equals(usuario.getAlias()) &&
					this.getPass().equals(usuario.getPass());
		}
		return res;
	}
	
	public String toString() {
		return "Alias: " + getAlias() + "\n" +
				"Pass: " + getPass();
	}
	/* - - - FIN METODOS - - - */
}
