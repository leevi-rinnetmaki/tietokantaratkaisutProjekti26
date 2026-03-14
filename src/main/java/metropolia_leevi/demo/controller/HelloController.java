package metropolia_leevi.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    @GetMapping
    public String hello(){
        return "Today might be 23.02.2026";
    }
}


