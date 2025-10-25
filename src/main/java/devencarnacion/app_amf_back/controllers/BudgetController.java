package devencarnacion.app_amf_back.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devencarnacion.app_amf_back.entities.Budget;
import devencarnacion.app_amf_back.entities.dto.BudgetRequest;
import devencarnacion.app_amf_back.entities.dto.BudgetResponse;
import devencarnacion.app_amf_back.services.BudgetService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @PostMapping
    public ResponseEntity<BudgetResponse> createBudget(@Valid @RequestBody BudgetRequest budgetRequest) {
    
        BudgetResponse response = budgetService.createBudget(budgetRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BudgetResponse>> getAllBudgets() {
        return new ResponseEntity<>(budgetService.getAllBudgets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBudgetById(@PathVariable Integer id) {
        return new ResponseEntity<>(budgetService.getBudgetById(id), HttpStatus.OK);
    }

    @GetMapping("type/{typeBudgetId}")
    public ResponseEntity<?> getBudgetsByType(@PathVariable Integer typeBudgetId) {
        return new ResponseEntity<>(budgetService.getAllBudgetsByType(typeBudgetId), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable Integer id, @RequestBody Budget budget) {
        return new ResponseEntity<>(budgetService.updateBudget(id, budget), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBudget(@PathVariable Integer id) {
        budgetService.deleteBudget(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
