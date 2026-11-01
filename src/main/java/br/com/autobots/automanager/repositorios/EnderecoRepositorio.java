package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "enderecos", path = "enderecos")
public interface EnderecoRepositorio extends JpaRepository<Endereco, Long> {
}
