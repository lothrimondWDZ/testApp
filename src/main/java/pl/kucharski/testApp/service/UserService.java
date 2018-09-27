package pl.kucharski.testApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kucharski.testApp.entity.User;
import pl.kucharski.testApp.repository.UserRepository;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User get(Long id) {
        return userRepository.getOne(id);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(Long id) {
        User u = userRepository.getOne(id);
        if (Objects.isNull(u)) {
            throw new IllegalArgumentException("User does not exist in database");
        }
        userRepository.delete(u);
    }

    public User update(User user) {
        return userRepository.save(user);
    }
}
