package todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import todoapp.model.TheThing;
import todoapp.repo.ToDoRepo;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/to-do")
public class ToDoController {

    @Autowired
    ToDoRepo toDoRepo;

    @GetMapping
    public String toDoPage(Model model) {
        TheThing thing1 = new TheThing();
        List<TheThing> things = toDoRepo.findAll();
        List<TheThing> done = new ArrayList<>();
        List<TheThing> toDo = new ArrayList<>();

        for (TheThing thing : things) {
            if (thing.isCheckIfDone()) {
                done.add(thing);
            } else {
                toDo.add(thing);
            }
        }
        model.addAttribute("thing1", thing1);
        model.addAttribute("done", done);
        model.addAttribute("todo", toDo);

        return "to-do";
    }


    @PostMapping("/save")
    public String create(Model model, TheThing theThing) {

        toDoRepo.save(theThing);

        return "redirect:/to-do";
    }


    @GetMapping("/delete/{id}")
    public String removeToDo(@PathVariable Long id) {
        TheThing thing = toDoRepo.findById(id).orElse(null);
        assert thing != null;
        toDoRepo.delete(thing);
        return "redirect:/to-do";
    }
}
