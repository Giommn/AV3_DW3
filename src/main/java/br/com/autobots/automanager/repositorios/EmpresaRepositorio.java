package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "empresas", path = "empresas")
public interface EmpresaRepositorio extends JpaRepository<Empresa, Long> {
}
