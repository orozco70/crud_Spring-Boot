package directorio.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import directorio.demo.model.DetalleVenta;

public interface RepoDetalleV  extends JpaRepository<DetalleVenta, Long>{

}
