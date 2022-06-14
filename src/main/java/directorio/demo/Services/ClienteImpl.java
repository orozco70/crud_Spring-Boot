package directorio.demo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import directorio.demo.model.Cliente;
import directorio.demo.repo.RepoCliente;

@Service
public class ClienteImpl implements ClienteService {

	@Autowired
	private RepoCliente repo_cli;

	@Override
	public Optional<Cliente> findbyid(Long id) {

		return repo_cli.findById(id);
	}

	@Override
	public Iterable<Cliente> findall() {

		return repo_cli.findAll();
	}

	@Override
	public Cliente agregar(Cliente dep) {

		return repo_cli.save(dep);
	}

	@Override
	public void eliminar(Long id) {

		repo_cli.deleteById(id);

	}

	

	
	
	

}
