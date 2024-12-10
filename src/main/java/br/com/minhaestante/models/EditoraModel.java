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
@Table(name = "editoras")
public class EditoraModel {

    @Id
    @Column(name = "id_editora", nullable = false, unique = true, length = 16, columnDefinition = "BINARY(16)")
    private UUID id_editora;

    @NotNull(message = "O campo nome editora é obrigatório")
    @Size(min = 2, max = 255, message = "O campo nome editora deve ter pelo menos 2 caracteres")
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dataRegistro;

    @Column(name = "dt_inativacao", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dt_inativacao;

    // RELACIONAMENTO
    @NotNull(message = "O campo livro é obrigatório")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "editora", fetch = FetchType.LAZY)
    private Set<LivroModel> livros = new HashSet<>();
}
