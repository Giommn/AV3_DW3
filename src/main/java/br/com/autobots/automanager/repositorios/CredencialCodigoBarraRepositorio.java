package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.CredencialCodigoBarra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "credenciais-codigo-barras", path = "credenciais-codigo-barras")
public interface CredencialCodigoBarraRepositorio extends JpaRepository<CredencialCodigoBarra, Long> {
}
