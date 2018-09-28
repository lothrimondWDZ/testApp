package pl.kucharski.testApp.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import pl.kucharski.testApp.enums.JobCategory;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "T_JOB_OFFER")
public class JobOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "JOB_CATEGORY", nullable = false)
    private JobCategory jobCategory;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "VALID_FROM", nullable = false)
    private LocalDate validFrom;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @Column(name = "VALID_TO")
    private LocalDate validTo;

    @Column(name = "EMPLOYER_NAME", nullable = false)
    private String employerName;

    @JsonBackReference("jobs")
    @ManyToOne
    @JoinColumn(name = "OWNER_ID")
    private User owner;

    public JobOffer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobOffer jobOffer = (JobOffer) o;
        return Objects.equals(id, jobOffer.id) &&
                Objects.equals(title, jobOffer.title) &&
                jobCategory == jobOffer.jobCategory &&
                Objects.equals(validFrom, jobOffer.validFrom) &&
                Objects.equals(validTo, jobOffer.validTo) &&
                Objects.equals(employerName, jobOffer.employerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, jobCategory, validFrom, validTo, employerName);
    }

    @Override
    public String toString() {
        return "JobOffer{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", jobCategory=" + jobCategory +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", employerName='" + employerName + '\'' +
                '}';
    }
}
