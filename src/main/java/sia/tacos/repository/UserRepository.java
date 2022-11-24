package sia.tacos.repository;

import org.springframework.data.repository.CrudRepository;

import sia.tacos.data.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
