package br.com.autobots.automanager.config;

import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RepositoryRestController
public class CredencialReadOnlyController {

    @RequestMapping(method = RequestMethod.POST, path = "/credenciais")
    public ResponseEntity<Void> create() {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }
}
