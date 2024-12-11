package br.com.minhaestante.repository;

import br.com.minhaestante.models.AvaliacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AvaliacaoRepository extends JpaRepository<AvaliacaoModel, UUID> {
}
