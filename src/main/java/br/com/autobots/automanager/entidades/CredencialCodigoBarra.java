package br.com.autobots.automanager.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class CredencialCodigoBarra extends Credencial {
    @Column(nullable = false, unique = true)
    private Long codigo;

    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }
}
