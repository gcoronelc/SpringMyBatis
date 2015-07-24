package pe.egcc.ventas.model;

/**
 * 
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 *
 */
public class UsuarioBean {

	private Integer idemp;
	private String usuario;
	
	public UsuarioBean() {
  }

	public UsuarioBean(Integer idemp, String usuario) {
	  super();
	  this.idemp = idemp;
	  this.usuario = usuario;
  }

	public Integer getIdemp() {
		return idemp;
	}

	public void setIdemp(Integer idemp) {
		this.idemp = idemp;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
}
