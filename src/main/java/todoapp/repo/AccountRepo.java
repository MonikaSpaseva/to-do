package todoapp.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import todoapp.model.UserAccount;

import java.util.List;

@Repository
public interface AccountRepo extends CrudRepository<UserAccount, Long> {

    @Override
    List<UserAccount> findAll();
}
