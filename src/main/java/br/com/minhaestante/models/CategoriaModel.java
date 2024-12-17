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
@Table(name = "categorias")
public class CategoriaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_categoria", nullable = false, unique = true, length = 16, columnDefinition = "BINARY(16)")
    private UUID id_categoria;

    @NotNull(message = "O campo nome categoria é obrigatório")
    @Size(min = 2, max = 255, message = "O nome deve ter entre 2 e 255 caracteres")
    @Column(name = "nome", nullable = false, unique = true, length = 255)
    private String nome;

    @JsonProperty("dt_registro")
    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dataRegistro;

    @Column(name = "dt_inativacao", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dt_inativacao;

    // RELACIONAMENTO
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LivrosCategoriaModel> livrosCategorias = new HashSet<>();

    public UUID getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(UUID id_categoria) {
        this.id_categoria = id_categoria;
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

    public Set<LivrosCategoriaModel> getLivrosCategorias() {
        return livrosCategorias;
    }

    public void setLivrosCategorias(Set<LivrosCategoriaModel> livrosCategorias) {
        this.livrosCategorias = livrosCategorias;
    }
}
