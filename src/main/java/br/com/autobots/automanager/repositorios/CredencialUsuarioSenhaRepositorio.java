package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.CredencialUsuarioSenha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "credenciais-usuario-senha", path = "credenciais-usuario-senha")
public interface CredencialUsuarioSenhaRepositorio extends JpaRepository<CredencialUsuarioSenha, Long> {
}
