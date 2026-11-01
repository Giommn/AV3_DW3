package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.Credencial;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "credenciais", path = "credenciais")
public interface CredencialRepositorio extends Repository<Credencial, Long> {

    Optional<Credencial> findById(Long id);

    Iterable<Credencial> findAll();

    Page<Credencial> findAll(Pageable pageable);
}
