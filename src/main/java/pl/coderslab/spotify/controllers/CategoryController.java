package pl.coderslab.spotify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spotify.entity.Category;
import pl.coderslab.spotify.repository.CategoryRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    //addCategory


    //add
    @GetMapping("/add")
    public String showFormUser(Model model) {
        model.addAttribute("category", new Category());
        return "category/add";
    }

    @PostMapping("/add")

    public String perform(@ModelAttribute @Valid Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/add";
        }
        categoryRepository.save(category);
        return "redirect:/category/showAll";

    }

    //listCategories

    @GetMapping("/showAll")
    public String toString(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        return "category/showAll";
    }

//showOne

    @GetMapping("/showOne/{id}")

    public String showOne(Model model, @PathVariable Long id) {
        model.addAttribute("category", categoryRepository.getOne(id));
        return "category/showOne";

    }

    //deleteCategory
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {

        categoryRepository.delete(categoryRepository.getOne(id));
        return "redirect:/welcomeAd";
    }

    //updateCategory

    @GetMapping("/update/{id}")
    public String showForm(Model model, @PathVariable long id) {
        model.addAttribute("category", categoryRepository.findById(id));
        return "category/update";
    }

    @PostMapping("/update")
    public String performUpdate(@ModelAttribute Category category) {
        categoryRepository.save(category);
        return "redirect:/category/showAll";

    }

}
