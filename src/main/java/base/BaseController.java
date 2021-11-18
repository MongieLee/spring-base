package base;

import base.dao.RankDao;
import base.dao.UserMapper;
import base.entity.User;
import base.service.RankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    private final UserMapper userMapper;
    private final RankService rankService;

    public BaseController(UserMapper userMapper, RankService rankService) {
        this.userMapper = userMapper;
        this.rankService = rankService;
    }

    @GetMapping("/search")
    public String search(@RequestParam("name") String name, @RequestParam(value = "age", required = false) String age) {
        return "your's query'sname = " + name + age;
    }

    @GetMapping("/fuck")
    public Object fuck() {
        return   rankService.getRank();
    }
}