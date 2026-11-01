package br.com.autobots.automanager.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String razaoSocial;
    @Column
    private String nomeFantasia;
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private Set<Telefone> telefones = new LinkedHashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @NotNull @Column(nullable = false)
    private LocalDateTime cadastro;
    @OneToMany(mappedBy = "empresa")
    private Set<Usuario> usuarios = new LinkedHashSet<>();
    @OneToMany(mappedBy = "empresa")
    private Set<Mercadoria> mercadorias = new LinkedHashSet<>();
    @OneToMany(mappedBy = "empresa")
    private Set<Servico> servicos = new LinkedHashSet<>();
    @OneToMany(mappedBy = "empresa")
    private Set<Venda> vendas = new LinkedHashSet<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getRazaoSocial() { return razaoSocial; }
    public void setRazaoSocial(String razaoSocial) { this.razaoSocial = razaoSocial; }
    public String getNomeFantasia() { return nomeFantasia; }
    public void setNomeFantasia(String nomeFantasia) { this.nomeFantasia = nomeFantasia; }
    public Set<Telefone> getTelefones() { return telefones; }
    public void setTelefones(Set<Telefone> telefones) { this.telefones = telefones; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public LocalDateTime getCadastro() { return cadastro; }
    public void setCadastro(LocalDateTime cadastro) { this.cadastro = cadastro; }
    public Set<Usuario> getUsuarios() { return usuarios; }
    public void setUsuarios(Set<Usuario> usuarios) { this.usuarios = usuarios; }
    public Set<Mercadoria> getMercadorias() { return mercadorias; }
    public void setMercadorias(Set<Mercadoria> mercadorias) { this.mercadorias = mercadorias; }
    public Set<Servico> getServicos() { return servicos; }
    public void setServicos(Set<Servico> servicos) { this.servicos = servicos; }
    public Set<Venda> getVendas() { return vendas; }
    public void setVendas(Set<Venda> vendas) { this.vendas = vendas; }
}
