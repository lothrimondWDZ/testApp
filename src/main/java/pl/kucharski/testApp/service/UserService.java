package pl.kucharski.testApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kucharski.testApp.entity.User;
import pl.kucharski.testApp.repository.AuthoritiesRepository;
import pl.kucharski.testApp.repository.UserRepository;

import java.util.Objects;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

    public User get(Long id) {
        return userRepository.getOne(id);
    }

    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    	return userRepository.save(user);
    }

    public void delete(Long id) {
        User u = userRepository.getOne(id);
        if (Objects.nonNull(u)) {
            u.getAuthorities().forEach(a -> authoritiesRepository.delete(a));
        }
        userRepository.delete(u);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
