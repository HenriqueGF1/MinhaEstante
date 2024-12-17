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
@Table(name = "autores")
public class AutorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "'id_autor'", nullable = false, unique = true, length = 16, columnDefinition = "BINARY(16)")
    private UUID id_autor;

    @NotNull(message = "O campo nome autor é obrigatório")
    @Size(min = 2, max = 255, message = "O autor deve ter pelo menos 2 caracteres")
    @Column(name = "nome", nullable = false, unique = true, length = 255)
    private String nome;

    @JsonProperty("dt_registro")
    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dataRegistro;

    @Column(name = "dt_inativacao", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dt_inativacao;

    // RELACIONAMENTO
    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LivroAutorModel> autoresLivros = new HashSet<>();

    public UUID getId_autor() {
        return id_autor;
    }

    public void setId_autor(UUID id_autor) {
        this.id_autor = id_autor;
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

    public Set<LivroAutorModel> getAutoresLivros() {
        return autoresLivros;
    }

    public void setAutoresLivros(Set<LivroAutorModel> autoresLivros) {
        this.autoresLivros = autoresLivros;
    }
}
