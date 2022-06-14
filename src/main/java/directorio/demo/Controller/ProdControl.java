package directorio.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.qos.logback.core.status.Status;
import directorio.demo.Services.ProducImpl;
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

	/*
	 * @RequestMapping(value ="/test{nombre}", method = RequestMethod.GET) public
	 * ResponseEntity<List<Producto>> test(@PathVariable("nombre") String nombre) {
	 * List<Producto> cli =prodrepo.findByNombre(nombre); return
	 * ResponseEntity.ok(cli); }
	 */
	/*
	 * @RequestMapping(value ="/test{nombre}", method = RequestMethod.GET) public
	 * ResponseEntity<Iterable<Producto>> test(String nombre) {
	 * 
	 * Iterable<Producto> cli = null;
	 * 
	 * try { cli =prod_impl.listapornombre(nombre);
	 * 
	 * } catch (Exception e) { // TODO: handle exception }
	 * 
	 * 
	 * return ResponseEntity.ok(cli); }
	 */

	@RequestMapping(value = "/test{nombre}", method = RequestMethod.GET)
	public ResponseEntity<?> test(String nombre) {

		try {
			return ResponseEntity.status(HttpStatus.OK).body(prod_impl.listapornombre(nombre));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\" }"));
		}

	}

	@PostMapping("/save")
	public void save(Producto pr) {
		prod_impl.agregar(pr);

	}
}
