package todoapp.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todoapp.model.TheThing;
import todoapp.repo.ToDoRepo;

@RestController
@RequestMapping("/api/todo")
public class TodoRestController {

    @Autowired
    ToDoRepo repo;

    @PostMapping("/check/{id}")
    public void check(@PathVariable("id") Long id) {

        TheThing thing = repo.findById(id).orElse(null);
        thing.setCheckIfDone(true);
        repo.save(thing);
    }
}
