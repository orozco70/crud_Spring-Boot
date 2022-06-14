package directorio.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import directorio.demo.model.Cliente;

public interface RepoCliente extends JpaRepository<Cliente, Long>{
	



}
