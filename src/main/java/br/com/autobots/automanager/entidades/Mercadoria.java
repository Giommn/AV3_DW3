package br.com.autobots.automanager.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Mercadoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull @Column(nullable = false)
    private LocalDate validade;
    @NotNull @Column(nullable = false)
    private LocalDate fabricacao;
    @NotNull @Column(nullable = false)
    private LocalDateTime cadastro;
    @NotBlank @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private Long quantidade;
    @Column(nullable = false)
    private BigDecimal valor;
    @Column
    private String descricao;
    @ManyToOne(optional = false)
    private Empresa empresa;
    @ManyToOne
    private Usuario fornecedor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getValidade() { return validade; }
    public void setValidade(LocalDate validade) { this.validade = validade; }
    public LocalDate getFabricacao() { return fabricacao; }
    public void setFabricacao(LocalDate fabricacao) { this.fabricacao = fabricacao; }
    public LocalDateTime getCadastro() { return cadastro; }
    public void setCadastro(LocalDateTime cadastro) { this.cadastro = cadastro; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public Long getQuantidade() { return quantidade; }
    public void setQuantidade(Long quantidade) { this.quantidade = quantidade; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Empresa getEmpresa() { return empresa; }
    public void setEmpresa(Empresa empresa) { this.empresa = empresa; }
    public Usuario getFornecedor() { return fornecedor; }
    public void setFornecedor(Usuario fornecedor) { this.fornecedor = fornecedor; }
}
