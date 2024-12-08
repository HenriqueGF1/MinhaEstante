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
    @Column(name = "id_usuario", nullable = false, unique = true,  length = 16, columnDefinition = "BINARY(16)")
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
    // Livros Favoritos
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<FavoritoModel> favorito = new HashSet<>();

    // Avaliacaoes de Livros
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<AvaliacaoModel> avaliacao = new HashSet<>();
}
