package pe.egcc.ventas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.egcc.ventas.dao.espec.ProductoMapper;
import pe.egcc.ventas.model.CategoriaBean;
import pe.egcc.ventas.model.ProductoBean;

@Service
public class ProductoService {

  @Autowired
  private ProductoMapper productoMapper;

  public List<ProductoBean> traerTodos() {
    return productoMapper.traerTodos();
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void insertar(ProductoBean productoBean) {
    productoMapper.insertar(productoBean);
  }

  public List<CategoriaBean> traerCategorias() {
    return productoMapper.traerCategorias();
  }

}
