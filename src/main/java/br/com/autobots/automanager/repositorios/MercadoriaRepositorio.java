package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "mercadorias", path = "mercadorias")
public interface MercadoriaRepositorio extends JpaRepository<Mercadoria, Long> {
}
