package js.hz.com.springstart.repositories;

import js.hz.com.springstart.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
