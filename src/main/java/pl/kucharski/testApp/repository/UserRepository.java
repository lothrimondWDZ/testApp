package pl.kucharski.testApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kucharski.testApp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);

}