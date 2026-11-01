package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vendas", path = "vendas")
public interface VendaRepositorio extends JpaRepository<Venda, Long> {
}
