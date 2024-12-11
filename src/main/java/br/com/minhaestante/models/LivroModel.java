package br.com.minhaestante.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(
        name = "livros",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_livro", "id_editora"})
)
public class LivroModel {

    @Id
    @Column(name = "id_livro", nullable = false, unique = true, length = 16, columnDefinition = "BINARY(16)")
    private UUID id_livro;

    @NotNull(message = "O campo titulo é obrigatório")
    @Size(min = 2, max = 255, message = "O campo titulo deve ter pelo menos 2 caracteres")
    @Column(name = "titulo", nullable = false, length = 255)
    private String titulo;

    @Column(name = "descricao", nullable = true, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "capa", nullable = true, length = 255)
    private String capa;

    @NotNull(message = "O campo quantidade de paginas é obrigatório")
    @Column(name = "qtd_paginas", nullable = false)
    private Integer qtdPaginas;

    @Column(name = "isbn", unique = true, nullable = true, length = 20)
    private String isbn;

    @NotNull(message = "O campo data de publicacao é obrigatório")
    @Column(name = "dt_publicacao", nullable = false)
    private LocalDateTime dtPublicacao;

    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dtRegistro;

    @Column(name = "dt_inativacao", nullable = true, columnDefinition = "DATETIME")
    private LocalDateTime dtInativacao;

    // RELACIONAMENTO
    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LivrosUsuarioModel> livrosUsuarios = new HashSet<>();

    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LivrosCategoriaModel> livrosCategorias = new HashSet<>();

    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LivroAutorModel> livrosAutores = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_editora", nullable = false)
    private EditoraModel editora;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY)
    private Set<AvaliacaoModel> avaliacao = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY)
    private Set<FavoritoModel> favorito = new HashSet<>();

    public UUID getId_livro() {
        return id_livro;
    }

    public void setId_livro(UUID id_livro) {
        this.id_livro = id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public Integer getQtdPaginas() {
        return qtdPaginas;
    }

    public void setQtdPaginas(Integer qtdPaginas) {
        this.qtdPaginas = qtdPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDateTime getDtPublicacao() {
        return dtPublicacao;
    }

    public void setDtPublicacao(LocalDateTime dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public LocalDateTime getDtRegistro() {
        return dtRegistro;
    }

    public void setDtRegistro(LocalDateTime dtRegistro) {
        this.dtRegistro = dtRegistro;
    }

    public LocalDateTime getDtInativacao() {
        return dtInativacao;
    }

    public void setDtInativacao(LocalDateTime dtInativacao) {
        this.dtInativacao = dtInativacao;
    }

    public Set<LivrosUsuarioModel> getLivrosUsuarios() {
        return livrosUsuarios;
    }

    public void setLivrosUsuarios(Set<LivrosUsuarioModel> livrosUsuarios) {
        this.livrosUsuarios = livrosUsuarios;
    }

    public Set<LivrosCategoriaModel> getLivrosCategorias() {
        return livrosCategorias;
    }

    public void setLivrosCategorias(Set<LivrosCategoriaModel> livrosCategorias) {
        this.livrosCategorias = livrosCategorias;
    }

    public Set<LivroAutorModel> getLivrosAutores() {
        return livrosAutores;
    }

    public void setLivrosAutores(Set<LivroAutorModel> livrosAutores) {
        this.livrosAutores = livrosAutores;
    }

    public EditoraModel getEditora() {
        return editora;
    }

    public void setEditora(EditoraModel editora) {
        this.editora = editora;
    }

    public Set<AvaliacaoModel> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Set<AvaliacaoModel> avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Set<FavoritoModel> getFavorito() {
        return favorito;
    }

    public void setFavorito(Set<FavoritoModel> favorito) {
        this.favorito = favorito;
    }
}
