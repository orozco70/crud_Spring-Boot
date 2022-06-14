package directorio.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import directorio.demo.Services.VentaImpl;
import directorio.demo.model.Venta;


@Controller
@RequestMapping("venta")
public class VentControl {
	
	@Autowired
	private VentaImpl vent_impl;
	
	@GetMapping("/all")
	public ResponseEntity<?> getall() {
		
		List<Venta> ventas = (List<Venta>) vent_impl.findall();
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(ventas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("{\"Error\": \"" + e.getMessage() + "\" }"));
		}
		
		
		
		
	}

}
