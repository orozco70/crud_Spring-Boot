package directorio.demo.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directorio.demo.model.DetalleVenta;
import directorio.demo.repo.RepoDetalleV;
@Service
public class DetalleImpl implements DetalleService {

	@Autowired
	private RepoDetalleV repo_detalle;

	@Override
	public Optional<DetalleVenta> findbyid(Long id) {
		
		return repo_detalle.findById(id);
	}

	@Override
	public Iterable<DetalleVenta> findall() {
		
		return repo_detalle.findAll();
	}

	@Override
	public DetalleVenta agregar(DetalleVenta dep) {
		
		return repo_detalle.save(dep);
	}

	@Override
	public void eliminar(Long id) {

		repo_detalle.deleteById(id);

	}

}
