package br.com.minhaestante.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "usuarios")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario", nullable = false, unique = true, length = 16, columnDefinition = "BINARY(16)")
    private UUID idUsuario;

    @NotNull(message = "O nome é obrigatório")
    @Size(min = 2, max = 255, message = "O nome deve ter entre 2 e 255 caracteres")
    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @NotNull(message = "O e-mail é obrigatório")
    @Email(message = "O e-mail deve ser válido")
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @NotNull(message = "A senha é obrigatória")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "dt_registro", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime dataRegistro;

    // RELACIONAMENTO
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<FavoritoModel> favoritos = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    // Esse mappedBy e o Objeto que eu crio no relacionamento da private SetAbaixo , nesse caso do Usuario na model de avaliacao
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<AvaliacaoModel> avaliacao = new HashSet<>();

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<LivrosUsuarioModel> livrosUsuarios = new HashSet<>();

    public UUID getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UUID idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Set<FavoritoModel> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(Set<FavoritoModel> favoritos) {
        this.favoritos = favoritos;
    }

    public Set<AvaliacaoModel> getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Set<AvaliacaoModel> avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Set<LivrosUsuarioModel> getLivrosUsuarios() {
        return livrosUsuarios;
    }

    public void setLivrosUsuarios(Set<LivrosUsuarioModel> livrosUsuarios) {
        this.livrosUsuarios = livrosUsuarios;
    }
}
