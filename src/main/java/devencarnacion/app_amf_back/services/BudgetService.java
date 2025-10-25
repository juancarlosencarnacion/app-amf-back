package devencarnacion.app_amf_back.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devencarnacion.app_amf_back.entities.Budget;
import devencarnacion.app_amf_back.entities.dto.BudgetRequest;
import devencarnacion.app_amf_back.entities.dto.BudgetResponse;
import devencarnacion.app_amf_back.repositories.BudgetRepository;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private BudgetDTOMapper budgetDTOMapper;

    public BudgetResponse createBudget(BudgetRequest request) {
        Budget budget = budgetDTOMapper.fromRequest(request);

        Budget savedBudget = budgetRepository.save(budget);

        return budgetDTOMapper.apply(savedBudget);
    }

    public List<BudgetResponse> getAllBudgets() {
        return budgetRepository.findAll()
                .stream()
                .map(budgetDTOMapper)
                .toList();
    }

    public BudgetResponse getBudgetById(Integer id) {
        Budget budget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found"));

        return budgetDTOMapper.apply(budget);
    }

    public List<Budget> getAllBudgetsByType(Integer typeBudgetId) {
        return budgetRepository.findAllByTypeBudgetId(typeBudgetId);
    }

    public Budget updateBudget(Integer id, Budget budget) {
        Budget currentBudget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el budget con el id " + id));

        if (budget.getUser() != null) {
            currentBudget.setUser(budget.getUser());
        }

        if (budget.getCategory() != null) {
            currentBudget.setCategory(budget.getCategory());
        }

        if (budget.getTypeBudget() != null) {
            currentBudget.setTypeBudget(budget.getTypeBudget());
        }

        if (budget.getAmount() != null) {
            currentBudget.setAmount(budget.getAmount());
        }

        return budgetRepository.save(currentBudget);
    }

    public void deleteBudget(Integer id) {
        Budget currentBudget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el budget con el id " + id));

        budgetRepository.delete(currentBudget);
    }
}
