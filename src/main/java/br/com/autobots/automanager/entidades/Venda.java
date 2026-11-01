package br.com.autobots.automanager.entidades;

import jakarta.persistence.Column;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import java.util.LinkedHashSet;
import java.util.Set;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Column(nullable = false)
    private LocalDateTime cadastro;
    @NotBlank @Column(nullable = false, unique = true)
    private String identificacao;
    @ManyToOne(optional = false)
    private Usuario cliente;
    @ManyToOne(optional = false)
    private Usuario funcionario;
    @ManyToMany
    private Set<Mercadoria> mercadorias = new LinkedHashSet<>();
    @ManyToMany
    private Set<Servico> servicos = new LinkedHashSet<>();
    @ManyToOne
    private Veiculo veiculo;
    @ManyToOne(optional = false)
    private Empresa empresa;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getCadastro() { return cadastro; }
    public void setCadastro(LocalDateTime cadastro) { this.cadastro = cadastro; }
    public String getIdentificacao() { return identificacao; }
    public void setIdentificacao(String identificacao) { this.identificacao = identificacao; }
    public Usuario getCliente() { return cliente; }
    public void setCliente(Usuario cliente) { this.cliente = cliente; }
    public Usuario getFuncionario() { return funcionario; }
    public void setFuncionario(Usuario funcionario) { this.funcionario = funcionario; }
    public Set<Mercadoria> getMercadorias() { return mercadorias; }
    public void setMercadorias(Set<Mercadoria> mercadorias) { this.mercadorias = mercadorias; }
    public Set<Servico> getServicos() { return servicos; }
    public void setServicos(Set<Servico> servicos) { this.servicos = servicos; }
    public Veiculo getVeiculo() { return veiculo; }
    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }
    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
}
