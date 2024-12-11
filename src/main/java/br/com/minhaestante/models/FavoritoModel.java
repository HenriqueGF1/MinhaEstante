package br.com.minhaestante.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "favoritos",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_usuario", "id_livro"})
)
public class FavoritoModel {

    @Id
    @Column(name = "id_favorito", nullable = false, unique = true, length = 16, columnDefinition = "BINARY(16)")
    private UUID id_favorito;

    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dtRegistro;

    // RELACIONAMENTO
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioModel usuario;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livro", nullable = false)
    private LivroModel livro;

    public UUID getId_favorito() {
        return id_favorito;
    }

    public void setId_favorito(UUID id_favorito) {
        this.id_favorito = id_favorito;
    }

    public LocalDateTime getDtRegistro() {
        return dtRegistro;
    }

    public void setDtRegistro(LocalDateTime dtRegistro) {
        this.dtRegistro = dtRegistro;
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
