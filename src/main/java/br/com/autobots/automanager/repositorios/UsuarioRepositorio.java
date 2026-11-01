package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
