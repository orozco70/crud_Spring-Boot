package directorio.demo.Services;

import java.util.List;
import java.util.Optional;

import directorio.demo.model.Cliente;

public interface ClienteService {

	public Optional<Cliente> findbyid(Long id);

	public Iterable<Cliente> findall();

	public Cliente agregar(Cliente dep);

	public void eliminar(Long id);
	
	//public List<Cliente> test(String nombre);
	

}
