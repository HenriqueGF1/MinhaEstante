package br.com.minhaestante.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "editoras")
public class Editoras {

    @Id
    @Column(name = "id_editoras", nullable = false, unique = true, length = 36, columnDefinition = "CHAR(36)")
    private UUID id_editoras;

    @NotNull(message = "O campo nome editora é obrigatório")
    @Size(min = 2, max = 255, message = "O campo nome editora deve ter pelo menos 2 caracteres")
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dataRegistro;

    @Column(name = "dt_inativacao", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dt_inativacao;

    public Editoras(String nome, LocalDateTime dataRegistro) {
        this.nome = nome;
        this.dataRegistro = dataRegistro;
    }

    public Editoras(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getId_editoras() {
        return id_editoras;
    }

    public void setId_editoras(UUID id_editoras) {
        this.id_editoras = id_editoras;
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
