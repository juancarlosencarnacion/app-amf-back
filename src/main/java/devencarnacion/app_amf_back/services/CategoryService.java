package devencarnacion.app_amf_back.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devencarnacion.app_amf_back.entities.Category;
import devencarnacion.app_amf_back.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }

    public Category updateCategory(Integer id, Category category) {
        Category currentCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontro la categoria con el id " + id));

        if (category.getCategory() != null) {
            currentCategory.setCategory(category.getCategory());
        }

        if (category.getIcon() != null) {
            currentCategory.setIcon(category.getIcon());
        }

        return categoryRepository.save(currentCategory);
    }

    public void deleteCategory(Integer id) {
        Category currentCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la categoría con el id " + id));

        categoryRepository.delete(currentCategory);
    }
}
