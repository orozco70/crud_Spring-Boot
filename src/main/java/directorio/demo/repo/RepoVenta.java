package directorio.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import directorio.demo.model.Venta;

public interface RepoVenta  extends JpaRepository<Venta, Long>{

}
