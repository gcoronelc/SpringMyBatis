package pe.egcc.ventas.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.ventas.dao.espec.ProductoMapper;
import pe.egcc.ventas.model.ProductoBean;
import pe.egcc.ventas.model.UsuarioBean;
import pe.egcc.ventas.service.ProductoService;
import pe.egcc.ventas.service.UsuarioService;

@Controller
public class HomeController {

  private static final Logger logger = LoggerFactory
      .getLogger(HomeController.class);

  @Autowired
  private UsuarioService usuarioService;

  @Autowired
  private ProductoService productoService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {
    return "home";
  }

  @RequestMapping(value = "main.htm", method = RequestMethod.GET)
  public String main() {
    return "main";
  }

  @RequestMapping(value = "ingreso.htm", method = RequestMethod.POST)
  public ModelAndView ingreso(@RequestParam("usuario") String usuario,
      @RequestParam("clave") String clave, HttpServletRequest request) {

    ModelAndView mv = new ModelAndView();
    String destino;

    try {
      UsuarioBean bean = usuarioService.validar(usuario, clave);
      destino = "main";
    } catch (Exception e) {
      destino = "home";
      mv.addObject("error", e.getMessage());
    }

    mv.setViewName(destino);
    return mv;
  }

  @RequestMapping(value = "conProductos.htm", method = RequestMethod.GET)
  public ModelAndView conProductos() {
    ModelAndView mv = new ModelAndView("conProductos");
    mv.addObject("lista", productoService.traerTodos());
    return mv;
  }

  @RequestMapping(value = "insProducto.htm", method = RequestMethod.GET)
  public ModelAndView insProducto() {
    ModelAndView mav = new ModelAndView("insProducto");
    mav.addObject("categorias", productoService.traerCategorias());
    return mav;
  }

  @RequestMapping(value = "insProductoGrabar.htm", method = RequestMethod.POST)
  public ModelAndView insProductoGrabar(
      @ModelAttribute("productoBean") ProductoBean productoBean) {
    ModelAndView mv = new ModelAndView("insProducto");
    try {
      // Transaccion
      productoService.insertar(productoBean);
      // Retorno
      mv.addObject("msg", "Proceso ok. ID = " + productoBean.getIdprod() + ".");
    } catch (Exception e) {
      mv.addObject("error", e.getMessage());
    } 
    // Agregando las categorías.
    mv.addObject("categorias", productoService.traerCategorias());
    return mv;
  }

}
