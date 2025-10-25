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

import devencarnacion.app_amf_back.entities.TypeBudget;
import devencarnacion.app_amf_back.services.TypeBudgetService;

@RestController
@RequestMapping("/api/type_budget")
public class TypeBudgetController {

    @Autowired
    private TypeBudgetService typeBudgetService;

    @PostMapping
    public ResponseEntity<TypeBudget> createTypeBudget(@RequestBody TypeBudget typeBudget) {
        return new ResponseEntity<>(typeBudgetService.createTypeBudget(typeBudget), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TypeBudget>> getAllTypeBudget() {
        return new ResponseEntity<>(typeBudgetService.getAllTypeBudget(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTypeBudgetById(@PathVariable Integer id) {
        return new ResponseEntity<>(typeBudgetService.getTypeBudgetById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeBudget> updateTypeBudget(@PathVariable Integer id, @RequestBody TypeBudget typeBudget) {
        return new ResponseEntity<>(typeBudgetService.updateTypeBudget(id, typeBudget), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTypeBudget(@PathVariable Integer id) {
        typeBudgetService.deleteTypeBudget(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
