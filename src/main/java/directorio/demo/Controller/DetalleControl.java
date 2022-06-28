package directorio.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import directorio.demo.Services.DetalleImpl;
import directorio.demo.model.DetalleVenta;

@Controller
@RequestMapping("det")
public class DetalleControl {
	
	@Autowired
	private DetalleImpl detalImpl;
	
	@GetMapping(value = {"/","all",""})
	public ResponseEntity<List<DetalleVenta>> getall()
	{
		List<DetalleVenta> detallev = (List<DetalleVenta>) detalImpl.findall();
		
		return ResponseEntity.ok(detallev);
	}
	
	
	

}
