package base;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, @RequestParam(value = "age", required = false) String age) {
        return "your's query'sname = " + name + age;
    }

}