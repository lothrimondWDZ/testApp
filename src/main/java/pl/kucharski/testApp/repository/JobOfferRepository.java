package pl.kucharski.testApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import pl.kucharski.testApp.entity.JobOffer;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long>, QuerydslPredicateExecutor<JobOffer> {
}
