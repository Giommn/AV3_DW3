package br.com.autobots.automanager.repositorios;

import br.com.autobots.automanager.entidades.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "documentos", path = "documentos")
public interface DocumentoRepositorio extends JpaRepository<Documento, Long> {
}
