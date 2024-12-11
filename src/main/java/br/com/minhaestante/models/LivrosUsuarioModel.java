package br.com.minhaestante.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "livros_usuarios",
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_livro", "id_usuario"})
)
public class LivrosUsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_livro_usuario", nullable = false, unique = true, length = 16, columnDefinition = "BINARY(16)")
    private UUID id_livro_usuario;

    @NotNull(message = "A lido é obrigatórop")
    @Column(name = "lido", nullable = false)
    private Boolean lido;

    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dtRegistro;

    @Column(name = "dt_inativacao", nullable = true, columnDefinition = "DATETIME")
    private LocalDateTime dtInativacao;

    // RELACIONAMENTO
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livro", nullable = false)
    private LivroModel livro;

    public UUID getId_livro_usuario() {
        return id_livro_usuario;
    }

    public void setId_livro_usuario(UUID id_livro_usuario) {
        this.id_livro_usuario = id_livro_usuario;
    }

    public Boolean getLido() {
        return lido;
    }

    public void setLido(Boolean lido) {
        this.lido = lido;
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
