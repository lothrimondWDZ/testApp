package pl.kucharski.testApp.entity;

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

    @Column(name = "TITLE")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "JOB_CATEGORY")
    private JobCategory jobCategory;

    @Column(name = "VALID_FROM")
    private LocalDate validFrom;

    @Column(name = "VALID_TO")
    private LocalDate validTo;

    @Column(name = "EMPLOYER_NAME")
    private String employerName;

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
