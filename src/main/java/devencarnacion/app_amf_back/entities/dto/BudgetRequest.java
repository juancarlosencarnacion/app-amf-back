package devencarnacion.app_amf_back.entities.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BudgetRequest {

    @NotBlank
    private Integer userId;

    @NotBlank
    private Integer categoryId;

    @NotBlank
    private Integer typeBudgetId;

    @NotBlank
    private Double amount;
}
