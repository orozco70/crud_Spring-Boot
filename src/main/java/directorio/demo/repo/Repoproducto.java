package directorio.demo.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import directorio.demo.model.Producto;

public interface Repoproducto  extends JpaRepository<Producto, Long>{

	
@Query(value = "SELECT p.nombre, p.precio,p.id_producto from producto p "
		+ "JOIN detalleventa dv on p.id_producto = dv.id_producto "
		+ "JOIN venta v on v.id_venta = dv.id_venta   Inner JOIN cliente c on c.id_cliente = v.id_cliente"
		+ "  where c.nombre = :nombre ",nativeQuery = true)
	public  Iterable<Producto> listapornombre(String nombre);
	
}
