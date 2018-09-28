package pl.kucharski.testApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kucharski.testApp.entity.Authorities;
import pl.kucharski.testApp.entity.AuthoritiesKey;

public interface AuthoritiesRepository extends JpaRepository<Authorities, AuthoritiesKey> {
}
