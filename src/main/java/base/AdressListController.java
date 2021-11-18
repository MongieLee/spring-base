package base;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AdressListController {
    @GetMapping("/{father}/{child}/address")
    public void address(@PathVariable("father") String father, @PathVariable String child) {
        System.out.println(father);
        System.out.println(child);
    }

    @PostMapping("/create")
    public void create(@RequestBody Params obj) {
        System.out.println(obj.getA());
        System.out.println(obj);
    }

    @GetMapping("/111")
    public Object fuck(HttpServletRequest req, HttpServletResponse res) {
        Map<String, Object> result = new HashMap<>();

        result.put("fuck", Arrays.asList("1", "2"));
        return result;
    }
}
