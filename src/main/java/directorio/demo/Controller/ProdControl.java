package directorio.demo.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.status.Status;
import directorio.demo.Services.ProducImpl;
import directorio.demo.model.Cliente;
import directorio.demo.model.Producto;
import directorio.demo.repo.Repoproducto;

@Controller
@RequestMapping("prod")
public class ProdControl {

	@Autowired
	private ProducImpl prod_impl;

	@GetMapping("/all")
	public ResponseEntity<List<Producto>> getall() {
		List<Producto> prod = (List<Producto>) prod_impl.findall();
		return ResponseEntity.ok(prod);
	}


	@RequestMapping(value = { "/", "", "show" }, method = RequestMethod.GET)
	public String mostrar(Model model) {
		List<Producto> prod = (List<Producto>) prod_impl.findall();
		model.addAttribute("prodlist", prod);
		return "producto/lista";
	}

	@RequestMapping(value = { "/add/{id}" }, method = RequestMethod.GET)
	public String add(Model model, @PathVariable("id") Long id) {

		if (id == 0) {
			model.addAttribute("titulo", "Agregar Producto");
			model.addAttribute("producto", new Producto());

		} else {

			model.addAttribute("titulo", "Modificar Producto");
			model.addAttribute("producto", prod_impl.findbyid(id));

		}

		return "producto/add";
	}

	@PostMapping("/save")
	public String agrega(@Valid @ModelAttribute("producto")  Producto producto, BindingResult result, RedirectAttributes ra) {
	
		if (result.hasErrors()) {
			return "producto/add";
		}
		prod_impl.agregar(producto);
		ra.addFlashAttribute("MsgExito", "Guardado con Exito");
		return "redirect:/prod/show";

	}

	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable Long id, RedirectAttributes ra) {
		prod_impl.eliminar(id);
		ra.addFlashAttribute("msgExito", "Eliminado Correcto");
		return "redirect:/prod/show";
	}

}
