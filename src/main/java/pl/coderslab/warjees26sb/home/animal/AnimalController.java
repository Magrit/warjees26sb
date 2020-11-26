package pl.coderslab.warjees26sb.home.animal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.awt.print.Book;

@Controller
@RequestMapping("/animal")
public class AnimalController {
    private final AnimalRepository animalRepository;

    public AnimalController(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal/form";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String performForm(@Valid Animal animal, BindingResult result, RedirectAttributes redirAttrs) {
        if (result.hasErrors()) {
            return "animal/form";
        } else {
            animalRepository.save(animal);
        }
        redirAttrs.addFlashAttribute("message", "Animal was added successfully");
        return "redirect:/";
    }


}
