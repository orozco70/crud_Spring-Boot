package directorio.demo.Controller;

import java.util.List;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import directorio.demo.Services.ClienteImpl;
import directorio.demo.model.Cliente;

@Controller
@RequestMapping("/cli")
public class CliControl {

	@Autowired
	private ClienteImpl cliImpl;
	
	

	@GetMapping("/all")
	public ResponseEntity<List<Cliente>> getall() {
		List<Cliente> cli = (List<Cliente>) cliImpl.findall();
		return ResponseEntity.ok(cli);
	}

	@GetMapping("/add/{id}")
	public String add(Model model, @PathVariable("id") Long id) {

		try {
			if (id == 0) {
				model.addAttribute("cliente", new Cliente());
				model.addAttribute("titulo", "Agregar Cliente");

			} else {
				model.addAttribute("cliente", cliImpl.findbyid(id));
				model.addAttribute("titulo", "Modificar Cliente");
			}
		} catch (Exception e) {
       model.addAttribute("error", e.getMessage());
        return "error";
		}

		return "cliente/add";
	}

	@GetMapping(value = { "/show", "" })
	public String getall(Model model) {
		List<Cliente> cli = (List<Cliente>) cliImpl.findall();

		model.addAttribute("lista", cli);
		
		return "cliente/listcli";

	}

	@PostMapping("/save")
	public String agrega(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult result, RedirectAttributes ra) {

		if (result.hasErrors()) {
			return "cliente/add";
		}

		cliImpl.agregar(cliente);
		ra.addFlashAttribute("msgExito", "Guardado Correcto");
		return "redirect:/cli/show";
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<?> getone(@PathVariable Long id) {
		try {

			return ResponseEntity.status(HttpStatus.OK).body(cliImpl.findbyid(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"\"}");
		}
	}

	 @GetMapping("/del/{id}")
	    public String eliminar(@PathVariable Long id,RedirectAttributes ra) {
		 cliImpl.eliminar(id);
		 ra.addFlashAttribute("msgExito", "Eliminado Correcto");
		 return "redirect:/cli/show";
	    }
	
	
}
