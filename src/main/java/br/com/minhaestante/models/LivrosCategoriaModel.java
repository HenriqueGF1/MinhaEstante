package br.com.minhaestante.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(
        name = "livros_categorias",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_livro", "id_categoria"})
)
public class LivrosCategoriaModel {

    @Id
    @Column(name = "id_livro_categoria", nullable = false, unique = true, length = 16, columnDefinition = "BINARY(16)")
    private UUID id_livro_categoria;

    // RELACIONAMENTO
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livro", nullable = false)
    private LivroModel livro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaModel categoria;

    public UUID getId_livro_categoria() {
        return id_livro_categoria;
    }

    public void setId_livro_categoria(UUID id_livro_categoria) {
        this.id_livro_categoria = id_livro_categoria;
    }

    public LivroModel getLivro() {
        return livro;
    }

    public void setLivro(LivroModel livro) {
        this.livro = livro;
    }

    public CategoriaModel getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaModel categoria) {
        this.categoria = categoria;
    }
}
