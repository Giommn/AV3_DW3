package br.com.autobots.automanager.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import java.util.LinkedHashSet;
import java.util.Set;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import br.com.autobots.automanager.enumeracoes.PerfilUsuario;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Column(nullable = false)
    private String nome;
    @Column
    private String nomeSocial;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<PerfilUsuario> perfis = new LinkedHashSet<>();
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Telefone> telefones = new LinkedHashSet<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Documento> documentos = new LinkedHashSet<>();
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Email> emails = new LinkedHashSet<>();
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Credencial> credenciais = new LinkedHashSet<>();
    @OneToMany(mappedBy = "fornecedor")
    private Set<Mercadoria> mercadorias = new LinkedHashSet<>();
    @OneToMany(mappedBy = "cliente")
    private Set<Venda> vendasComoCliente = new LinkedHashSet<>();
    @OneToMany(mappedBy = "funcionario")
    private Set<Venda> vendasComoFuncionario = new LinkedHashSet<>();
    @OneToMany(mappedBy = "proprietario")
    private Set<Veiculo> veiculos = new LinkedHashSet<>();
    @ManyToOne
    private Empresa empresa;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getNomeSocial() { return nomeSocial; }
    public void setNomeSocial(String nomeSocial) { this.nomeSocial = nomeSocial; }
    public Set<PerfilUsuario> getPerfis() { return perfis; }
    public void setPerfis(Set<PerfilUsuario> perfis) { this.perfis = perfis; }
    public Set<Telefone> getTelefones() { return telefones; }
    public void setTelefones(Set<Telefone> telefones) { this.telefones = telefones; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public Set<Documento> getDocumentos() { return documentos; }
    public void setDocumentos(Set<Documento> documentos) { this.documentos = documentos; }
    public Set<Email> getEmails() { return emails; }
    public void setEmails(Set<Email> emails) { this.emails = emails; }
    public Set<Credencial> getCredenciais() { return credenciais; }
    public void setCredenciais(Set<Credencial> credenciais) { this.credenciais = credenciais; }
    public Set<Mercadoria> getMercadorias() { return mercadorias; }
    public void setMercadorias(Set<Mercadoria> mercadorias) { this.mercadorias = mercadorias; }
    public Set<Venda> getVendasComoCliente() { return vendasComoCliente; }
    public void setVendasComoCliente(Set<Venda> vendasComoCliente) { this.vendasComoCliente = vendasComoCliente; }
    public Set<Venda> getVendasComoFuncionario() { return vendasComoFuncionario; }
    public void setVendasComoFuncionario(Set<Venda> vendasComoFuncionario) { this.vendasComoFuncionario = vendasComoFuncionario; }
    public Set<Veiculo> getVeiculos() { return veiculos; }
    public void setVeiculos(Set<Veiculo> veiculos) { this.veiculos = veiculos; }
    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
}
