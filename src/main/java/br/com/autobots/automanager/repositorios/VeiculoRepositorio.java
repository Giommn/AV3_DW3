package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "veiculos", path = "veiculos")
public interface VeiculoRepositorio extends JpaRepository<Veiculo, Long> {
}
