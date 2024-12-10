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
@Table(name = "livros")
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

    // Editora
    @NotNull(message = "O campo editora é obrigatório")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_editora", nullable = false)
    private EditoraModel editora;

    // Favoritos
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY)
    private Set<FavoritoModel> favorito = new HashSet<>();

    // Livros e autores
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY)
    private Set<LivroAutorModel> livroAutores = new HashSet<>();

    // Categorias
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "livro", fetch = FetchType.LAZY)
    private Set<LivrosCategoriaModel> livrosCategorias = new HashSet<>();

}
