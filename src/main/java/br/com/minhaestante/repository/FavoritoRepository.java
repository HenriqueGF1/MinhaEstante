package br.com.minhaestante.repository;

import br.com.minhaestante.models.FavoritoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FavoritoRepository extends JpaRepository<FavoritoModel, UUID> {
}
