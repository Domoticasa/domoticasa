package modelo;

public class Usuario {
	/* - - - ATRIBUTOS - - - */
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
		return (this.getAlias().equals(usuario.getAlias()) && 
				this.getPass().equals(usuario.getPass()));
	}
	/* - - - FIN METODOS - - - */
}
