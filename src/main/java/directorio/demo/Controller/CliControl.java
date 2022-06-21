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

	@GetMapping("/add")
	public String add(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "cliente/add";
	}

	@GetMapping("/show")
	public String getall(Model model) {
		List<Cliente> cli = (List<Cliente>) cliImpl.findall();

		model.addAttribute("lista", cli);
		return "cliente/listcli";

	}

	@PostMapping("/save")
	public String agrega( @Valid Cliente cliente,BindingResult result ,RedirectAttributes ra ) {

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

	@GetMapping("/del{id}")
	public void eliminar(@PathVariable Long id) {

		cliImpl.eliminar(id);

	}
}
