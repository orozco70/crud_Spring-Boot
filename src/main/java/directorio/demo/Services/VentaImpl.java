package directorio.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directorio.demo.model.Venta;
import directorio.demo.repo.RepoVenta;

@Service
public class VentaImpl implements VentaService {

	@Autowired
	private RepoVenta repo_vent;

	@Override
	public Optional<Venta> findbyid(Long id) {

		return repo_vent.findById(id);
	}

	@Override
	public Iterable<Venta> findall() {

		return repo_vent.findAll();
	}

	@Override
	public Venta agregar(Venta dep) {

		return repo_vent.save(dep);
	}

	@Override
	public void eliminar(Long id) {

		repo_vent.deleteById(id);

	}

}
