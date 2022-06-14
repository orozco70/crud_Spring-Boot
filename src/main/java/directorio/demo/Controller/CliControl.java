package directorio.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	 @GetMapping("/{id}")
	 public ResponseEntity<?> getone(@PathVariable Long id) {
		 try {
				
				return  ResponseEntity.status(HttpStatus.OK).body(cliImpl.findbyid(id));
			} catch (Exception e) {
				return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"\"}");
			}
		}
	 
	 	 
	@GetMapping("/show")
	public String mostrar()
	{
		return "showall";
	}
	
	@PostMapping("/guardar")
    public  ResponseEntity<?> agregar(@RequestBody Cliente cl)
    {
		try {
	
			return  ResponseEntity.status(HttpStatus.OK).body(cliImpl.agregar(cl));
		} catch (Exception e) {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"\"}");
		}
	
			
	
	
			
    }
}
