package app.nesha.backend.repositories;

import app.nesha.backend.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}