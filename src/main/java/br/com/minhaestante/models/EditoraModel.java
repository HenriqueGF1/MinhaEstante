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

    @JsonProperty("dt_registro")
    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dataRegistro;

    @Column(name = "dt_inativacao", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dt_inativacao;

    // RELACIONAMENTO
    @OneToMany(mappedBy = "editora", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LivroModel> livros = new HashSet<>();

    public UUID getId_editora() {
        return id_editora;
    }

    public void setId_editora(UUID id_editora) {
        this.id_editora = id_editora;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public Set<LivroModel> getLivros() {
        return livros;
    }

    public void setLivros(Set<LivroModel> livros) {
        this.livros = livros;
    }
}
