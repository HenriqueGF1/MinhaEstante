package br.com.minhaestante.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "livros")
public class Livros {

    @Id
    @Column(name = "id_livro", nullable = false, unique = true, length = 36, columnDefinition = "CHAR(36)")
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

    public Livros(LocalDateTime dtPublicacao) {
        this.dtPublicacao = dtPublicacao;
    }

    public Livros(String titulo, String descricao, String capa, Integer qtdPaginas, String isbn, LocalDateTime dtPublicacao, LocalDateTime dtRegistro) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.capa = capa;
        this.qtdPaginas = qtdPaginas;
        this.isbn = isbn;
        this.dtPublicacao = dtPublicacao;
        this.dtRegistro = dtRegistro;
    }

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
}
