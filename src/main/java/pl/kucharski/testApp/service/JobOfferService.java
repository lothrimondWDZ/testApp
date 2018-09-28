package pl.kucharski.testApp.service;

import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.kucharski.testApp.entity.JobOffer;
import pl.kucharski.testApp.entity.QJobOffer;
import pl.kucharski.testApp.enums.JobCategory;
import pl.kucharski.testApp.repository.JobOfferRepository;

import java.util.Objects;

@Service
public class JobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    public JobOffer create(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    public Page<JobOffer> getByUserAndCategory(Long userId, String categoryName, Pageable pageable) {
        BooleanBuilder builder = prepareBuilder(userId, categoryName);
        return jobOfferRepository.findAll(builder, pageable);
    }

    private BooleanBuilder prepareBuilder(Long userId, String categoryName) {
        JobCategory category = null;
        if (StringUtils.isNotEmpty(categoryName)) {
            category = JobCategory.valueOf(categoryName);
        }
        QJobOffer jobOffer = QJobOffer.jobOffer;
        BooleanBuilder builder = new BooleanBuilder();
        if (Objects.nonNull(userId)) {
            builder.and(jobOffer.owner.id.eq(userId));
        }
        if (Objects.nonNull(category)) {
            builder.and(jobOffer.jobCategory.eq(category));
        }
        return builder;
    }
}
