package pl.kucharski.testApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.kucharski.testApp.entity.User;
import pl.kucharski.testApp.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

	@PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ResponseEntity getAll(Pageable pageable) {
        Page<User> u = userService.getAll(pageable);
        return ResponseEntity.ok(u);
    }

	@PreAuthorize("isAuthenticated()")
    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        User u = userService.get(id);
        return ResponseEntity.ok(u);
    }

	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody User user) {
        User u = userService.create(user);
        return ResponseEntity.ok(u);
    }

	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

	@PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody User user) {
        User u = userService.update(user);
        return ResponseEntity.ok(u);
    }
}
