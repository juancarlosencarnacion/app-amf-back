package devencarnacion.app_amf_back.repositories;

import devencarnacion.app_amf_back.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BudgetRepository extends JpaRepository<Budget, Integer> {
    List<Budget> findAllByTypeBudgetId(Integer typeBudgetId);
}
