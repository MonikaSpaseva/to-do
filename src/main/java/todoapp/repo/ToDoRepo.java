package todoapp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import todoapp.model.TheThing;

import java.util.List;

@Repository
public interface ToDoRepo extends CrudRepository<TheThing, Long> {
    @Override
    List<TheThing> findAll();
}
