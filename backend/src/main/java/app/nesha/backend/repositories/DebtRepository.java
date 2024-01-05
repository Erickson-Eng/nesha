package app.nesha.backend.repositories;

import app.nesha.backend.models.Debt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebtRepository extends JpaRepository<Debt, Long> {
}