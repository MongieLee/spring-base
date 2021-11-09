package base;

import org.springframework.web.bind.annotation.*;

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


}
