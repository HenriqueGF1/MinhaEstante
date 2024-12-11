package br.com.minhaestante.models;

import jakarta.persistence.*;

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

    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dtRegistro;

    @Column(name = "dt_inativacao", nullable = true, columnDefinition = "DATETIME")
    private LocalDateTime dtInativacao;

    // RELACIONAMENTO
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_livro", nullable = false)
    private LivroModel livro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = false)
    private AutorModel autor;

    public UUID getId_livro_autor() {
        return id_livro_autor;
    }

    public void setId_livro_autor(UUID id_livro_autor) {
        this.id_livro_autor = id_livro_autor;
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

    public LivroModel getLivro() {
        return livro;
    }

    public void setLivro(LivroModel livro) {
        this.livro = livro;
    }

    public AutorModel getAutor() {
        return autor;
    }

    public void setAutor(AutorModel autor) {
        this.autor = autor;
    }
}
