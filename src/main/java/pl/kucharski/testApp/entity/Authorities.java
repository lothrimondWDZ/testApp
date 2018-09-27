package pl.kucharski.testApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "T_AUTHORITIES")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Authorities implements Serializable {

    @EmbeddedId
    private AuthoritiesKey authoritiesKey;

    @Column(name = "ENABLED")
    private Boolean enabled;

    public Authorities() {
    }

    public AuthoritiesKey getAuthoritiesKey() {
        return authoritiesKey;
    }

    public void setAuthoritiesKey(AuthoritiesKey authoritiesKey) {
        this.authoritiesKey = authoritiesKey;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authorities that = (Authorities) o;
        return Objects.equals(authoritiesKey, that.authoritiesKey) &&
                Objects.equals(enabled, that.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authoritiesKey, enabled);
    }

    @Override
    public String toString() {
        return "Authorities{" +
                "authoritiesKey=" + authoritiesKey +
                ", enabled=" + enabled +
                '}';
    }
}
