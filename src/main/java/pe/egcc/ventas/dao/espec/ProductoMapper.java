package pe.egcc.ventas.dao.espec;

import java.util.List;

import pe.egcc.ventas.model.CategoriaBean;
import pe.egcc.ventas.model.ProductoBean;

public interface ProductoMapper {

  void insertar(ProductoBean productoBean);

  List<ProductoBean> traerTodos();

  List<CategoriaBean> traerCategorias();

}
