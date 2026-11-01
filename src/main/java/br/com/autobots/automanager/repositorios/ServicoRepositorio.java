package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "servicos", path = "servicos")
public interface ServicoRepositorio extends JpaRepository<Servico, Long> {
}
