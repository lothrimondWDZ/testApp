package pl.kucharski.testApp.entity;

import pl.kucharski.testApp.enums.Role;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AuthoritiesKey implements Serializable {

    private String login;

    @Enumerated(EnumType.STRING)
    private Role role;

    public AuthoritiesKey() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthoritiesKey that = (AuthoritiesKey) o;
        return Objects.equals(login, that.login) &&
                role == that.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, role);
    }

    @Override
    public String toString() {
        return "AuthoritiesKey{" +
                "login='" + login + '\'' +
                ", role=" + role +
                '}';
    }
}
