package sia.tacos.data;

import org.springframework.data.repository.CrudRepository;

import sia.tacos.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
