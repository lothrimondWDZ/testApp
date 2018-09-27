package pl.kucharski.testApp.rest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class MyErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

}
