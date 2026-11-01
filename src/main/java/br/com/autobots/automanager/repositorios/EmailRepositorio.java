package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "emails", path = "emails")
public interface EmailRepositorio extends JpaRepository<Email, Long> {
}
