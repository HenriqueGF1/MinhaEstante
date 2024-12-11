package br.com.minhaestante.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "avaliacoes",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_avaliacao", "id_usuario"})
)
public class AvaliacaoModel {

    @Id
    @Column(name = "id_avaliacao", nullable = false, unique = true, length = 16, columnDefinition = "BINARY(16)")
    private UUID id_avaliacao;

    @NotNull(message = "O texto avaliação. é obrigatório")
    @Size(min = 5, max = 255, message = "O texto avaliação deve ter entre 2 e 255 caracteres")
    @Column(name = "texto_avaliacao", nullable = false, length = 255)
    private String texto_avaliacao;

    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dataRegistro;

    @Column(name = "dt_inativacao", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dt_inativacao;

    // RELACIONAMENTO
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioModel usuario;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livro", nullable = false)
    private LivroModel livro;
}
































