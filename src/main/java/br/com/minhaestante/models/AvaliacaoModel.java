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

    public UUID getId_avaliacao() {
        return id_avaliacao;
    }

    public void setId_avaliacao(UUID id_avaliacao) {
        this.id_avaliacao = id_avaliacao;
    }

    public String getTexto_avaliacao() {
        return texto_avaliacao;
    }

    public void setTexto_avaliacao(String texto_avaliacao) {
        this.texto_avaliacao = texto_avaliacao;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDateTime getDt_inativacao() {
        return dt_inativacao;
    }

    public void setDt_inativacao(LocalDateTime dt_inativacao) {
        this.dt_inativacao = dt_inativacao;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public LivroModel getLivro() {
        return livro;
    }

    public void setLivro(LivroModel livro) {
        this.livro = livro;
    }
}
































