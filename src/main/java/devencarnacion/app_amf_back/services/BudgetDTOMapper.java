package devencarnacion.app_amf_back.services;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devencarnacion.app_amf_back.entities.Budget;
import devencarnacion.app_amf_back.entities.Category;
import devencarnacion.app_amf_back.entities.TypeBudget;
import devencarnacion.app_amf_back.entities.User;
import devencarnacion.app_amf_back.entities.dto.BudgetRequest;
import devencarnacion.app_amf_back.entities.dto.BudgetResponse;
import devencarnacion.app_amf_back.repositories.CategoryRepository;
import devencarnacion.app_amf_back.repositories.TypeBudgetRepository;
import devencarnacion.app_amf_back.repositories.UserRepository;

@Service
public class BudgetDTOMapper implements Function<Budget, BudgetResponse> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TypeBudgetRepository typeBudgetRepository;

    @Override
    public BudgetResponse apply(Budget budget) {
        return new BudgetResponse(
                budget.getId(),
                budget.getUser().getName(),
                budget.getCategory().getCategory(),
                budget.getTypeBudget().getTypeBudget(),
                budget.getAmount(),
                budget.getCreatedAt());
    }

    public Budget fromRequest(BudgetRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        TypeBudget typeBudget = typeBudgetRepository.findById(request.getTypeBudgetId())
                .orElseThrow(() -> new RuntimeException("Type budget not found"));

        Budget budget = new Budget();
        budget.setUser(user);
        budget.setCategory(category);
        budget.setTypeBudget(typeBudget);
        budget.setAmount(request.getAmount());

        return budget;
    }
}
