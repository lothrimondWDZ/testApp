package pl.kucharski.testApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kucharski.testApp.entity.JobOffer;
import pl.kucharski.testApp.entity.User;
import pl.kucharski.testApp.service.JobOfferService;
import pl.kucharski.testApp.service.UserService;

import java.util.List;

@RestController
public class JobOfferController {

    @Autowired
    private JobOfferService jobOfferService;

    @RequestMapping(path = "/job", method = RequestMethod.GET)
    public ResponseEntity getFilteredJobs(@RequestParam("userId") Long userId, @RequestParam("categoryName") String categoryName, Pageable pageable) {
        Page<JobOffer> page = jobOfferService.getByUserAndCategory(userId, categoryName, pageable);
        return ResponseEntity.ok(page);
    }

    @RequestMapping(path = "/job", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody JobOffer jobOffer) {
        JobOffer u = jobOfferService.create(jobOffer);
        return ResponseEntity.ok(u);
    }
}
