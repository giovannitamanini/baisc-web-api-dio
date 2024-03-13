package dio.web.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @Operation(summary = "Welcome page")
    @GetMapping
    public String welcome() {
        return "Welcome to my Spring Boot Web API";
    }
}

