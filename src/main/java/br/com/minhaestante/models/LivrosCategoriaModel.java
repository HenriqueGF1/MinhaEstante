package br.com.minhaestante.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
}
