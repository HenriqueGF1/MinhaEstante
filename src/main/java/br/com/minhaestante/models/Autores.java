package br.com.minhaestante.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "autores")
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "'id_autores'", nullable = false, unique = true, length = 36, columnDefinition = "CHAR(36)")
    private UUID id_autores;

    @NotNull(message = "O campo autor é obrigatório")
    @Size(min = 2,max = 255,message = "O autor deve ter pelo menos 2 caracteres")
    @Column(name = "autor", nullable = false, length = 255)
    private String autor;

    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dataRegistro;

    @Column(name = "dt_inativacao", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dt_inativacao;

    public Autores(String autor, LocalDateTime dataRegistro) {
        this.autor = autor;
        this.dataRegistro = dataRegistro;
    }

    public Autores(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public UUID getId_autores() {
        return id_autores;
    }

    public void setId_autores(UUID id_autores) {
        this.id_autores = id_autores;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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
}
