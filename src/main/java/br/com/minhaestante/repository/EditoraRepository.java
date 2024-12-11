package br.com.minhaestante.repository;

import br.com.minhaestante.models.EditoraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EditoraRepository extends JpaRepository<EditoraModel, UUID> {
}
