package directorio.demo.Services;

import java.util.Optional;

import directorio.demo.model.DetalleVenta;

public interface DetalleService {

	public Optional<DetalleVenta> findbyid(Long id);

	public Iterable<DetalleVenta> findall();

	public DetalleVenta agregar(DetalleVenta dep);

	public void eliminar(Long id);

}
