package base;

import base.TokenAnnotation.UserLoginToken;
import base.dao.UserMapper;
import base.entity.RankItem;
import base.entity.Result;
import base.entity.TestUser;
import base.service.RankService;
import base.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;

@RestController
public class BaseController {
    private final UserMapper userMapper;
    private final RankService rankService;
    private final UserService userService;

    public BaseController(UserMapper userMapper, RankService rankService, UserService userService) {
        this.userMapper = userMapper;
        this.rankService = rankService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        List<RankItem> items = rankService.getRank();
        HashMap<String, Object> model = new HashMap<>();
        model.put("items", items);
        return new ModelAndView("index", model);
    }


    @RequestMapping("/rankData")
    public Object r() {
        return rankService.getRank();
    }


    @UserLoginToken
    @GetMapping("/search")
    public String search() {
        return "Search";
    }


    @PostMapping("/api/login")
    public Object fuck(@RequestBody TestUser user) {
        System.out.println(user);
        TestUser userById = userService.getUserByName(user.getUsername());
        System.out.println(userById);
        if (userById == null) {
            return new Result(500, "用户不存在", false);
        } else {
            if (!userById.getPassword().equals(user.getPassword())) {
                return new Result(500, "密码错误", false);
            } else {
                String token = userService.getToken(userById);
                HashMap<String, Object> stringObjectHashMap = new HashMap<>();
                stringObjectHashMap.put("user", userById);
                stringObjectHashMap.put("token", token);
                return new Result(200, stringObjectHashMap, true);
            }

        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage() {
        return "你已通过token验证";
    }
}