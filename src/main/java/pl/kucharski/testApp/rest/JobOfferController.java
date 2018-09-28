package pl.kucharski.testApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kucharski.testApp.entity.JobOffer;
import pl.kucharski.testApp.service.JobOfferService;

import javax.validation.Valid;

@RestController
public class JobOfferController {

    @Autowired
    private JobOfferService jobOfferService;

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/job", method = RequestMethod.GET)
    public ResponseEntity getFilteredJobs(@RequestParam("userId") Long userId, @RequestParam("categoryName") String categoryName, Pageable pageable) {
        Page<JobOffer> page = jobOfferService.getByUserAndCategory(userId, categoryName, pageable);
        return ResponseEntity.ok(page);
    }

    @PreAuthorize("hasAuthority('COMPANY')")
    @RequestMapping(path = "/job", method = RequestMethod.POST)
    public ResponseEntity create(@Valid @RequestBody JobOffer jobOffer) {
        JobOffer u = jobOfferService.create(jobOffer);
        return ResponseEntity.ok(u);
    }
}
