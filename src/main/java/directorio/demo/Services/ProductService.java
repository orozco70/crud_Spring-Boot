package directorio.demo.Services;

import java.util.Optional;

import directorio.demo.model.Producto;

public interface ProductService {
	
	public Optional<Producto> findbyid(Long id);

	public Iterable<Producto> findall();

	public Producto agregar(Producto dep);

	public void eliminar(Long id);
	
	public  Iterable<Producto> listapornombre(String nombre);

}
