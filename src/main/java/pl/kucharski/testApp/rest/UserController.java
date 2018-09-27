package pl.kucharski.testApp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kucharski.testApp.entity.User;
import pl.kucharski.testApp.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        User u = userService.get(id);
        System.out.println(u);
        return ResponseEntity.ok(u);
    }

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity create(@RequestBody User user) {
        User u = userService.create(user);
        return ResponseEntity.ok(u);
    }

    @RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/user", method = RequestMethod.PUT)
    public ResponseEntity update(@RequestBody User user) {
        User u = userService.update(user);
        return ResponseEntity.ok(u);
    }
}
