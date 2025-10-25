package devencarnacion.app_amf_back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devencarnacion.app_amf_back.entities.TypeBudget;
import devencarnacion.app_amf_back.repositories.TypeBudgetRepository;

@Service
public class TypeBudgetService {

    @Autowired
    private TypeBudgetRepository typeBudgetRepository;

    public TypeBudget createTypeBudget(TypeBudget typeBudget) {
        return typeBudgetRepository.save(typeBudget);
    }

    public List<TypeBudget> getAllTypeBudget() {
        return typeBudgetRepository.findAll();
    }

    public Optional<TypeBudget> getTypeBudgetById(Integer id) {
        return typeBudgetRepository.findById(id);
    }

    public TypeBudget updateTypeBudget(Integer id, TypeBudget typeBudget) {
        TypeBudget currentTypeBudget = typeBudgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el tipo de budget con el id " + id));

        if(typeBudget.getTypeBudget() != null) {
            currentTypeBudget.setTypeBudget(typeBudget.getTypeBudget());
        }

        return typeBudgetRepository.save(currentTypeBudget);
    }

    public void deleteTypeBudget(Integer id) {
        TypeBudget currenTypeBudget = typeBudgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro el tipo de budget con el id " + id));

        typeBudgetRepository.delete(currenTypeBudget);
    }
}
