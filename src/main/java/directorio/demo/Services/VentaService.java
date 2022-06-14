package directorio.demo.Services;

import java.util.Optional;

import directorio.demo.model.Venta;

public interface VentaService {

	public Optional<Venta> findbyid(Long id);

	public Iterable<Venta> findall();

	public Venta agregar(Venta dep);

	public void eliminar(Long id);
}
