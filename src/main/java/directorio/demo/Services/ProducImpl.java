package directorio.demo.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directorio.demo.model.Producto;
import directorio.demo.repo.Repoproducto;

@Service
public class ProducImpl implements ProductService {

	@Autowired
	private Repoproducto repo_prod;
	
	@Override
	public Optional<Producto> findbyid(Long id) {
		
		return repo_prod.findById(id);
	}

	@Override
	public Iterable<Producto> findall() {
		
		return repo_prod.findAll();
	}

	@Override
	public Producto agregar(Producto dep) {
		
		return repo_prod.save(dep);
	}

	@Override
	public void eliminar(Long id) {
		repo_prod.deleteById(id);
		
	}

	@Override
	public Iterable<Producto> listapornombre(String nombre) {
		
		return repo_prod.listapornombre(nombre);
	}

}
