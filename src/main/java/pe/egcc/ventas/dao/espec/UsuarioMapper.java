package pe.egcc.ventas.dao.espec;

import org.apache.ibatis.annotations.Param;

import pe.egcc.ventas.model.UsuarioBean;

public interface UsuarioMapper {

	UsuarioBean traerUsuario(@Param("usuario") String usuario, @Param("clave") String clave);
	
}
