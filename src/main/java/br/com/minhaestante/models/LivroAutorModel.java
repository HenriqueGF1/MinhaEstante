package br.com.minhaestante.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "livros_autores",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_autor", "id_livro"})
)
public class LivroAutorModel {

    @Id
    @Column(name = "id_livro_autor", nullable = false, unique = true, length = 16, columnDefinition = "BINARY(16)")
    private UUID id_livro_autor;

    @NotNull(message = "O campo quantidade de paginas é obrigatório")
    @Column(name = "lido", nullable = false)
    private Boolean lido;

    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dtRegistro;

    @Column(name = "dt_inativacao", nullable = true, columnDefinition = "DATETIME")
    private LocalDateTime dtInativacao;

    // RELACIONAMENTO

    // Autor
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = false)
    private AutorModel autor;

    // Livros
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livro", nullable = false)
    private LivroModel livro;
}
