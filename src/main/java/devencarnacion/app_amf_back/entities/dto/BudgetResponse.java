package devencarnacion.app_amf_back.entities.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BudgetResponse {

    private Integer budgetId;

    private String user;

    private String category;

    private String typeBudget;

    private Double amount;

    private LocalDate createdAt;
}
