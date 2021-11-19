package base;

import base.TokenAnnotation.UserLoginToken;
import base.dao.RankDao;
import base.dao.UserMapper;
import base.entity.Result;
import base.entity.TestUser;
import base.entity.User;
import base.service.RankService;
import base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

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