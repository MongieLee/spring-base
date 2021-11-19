package base;

import base.TokenAnnotation.PassToken;
import base.TokenAnnotation.UserLoginToken;
import base.entity.TestUser;
import base.service.UserService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken annotation = method.getAnnotation(PassToken.class);
            if (annotation.required()) {
                return true;
            }
        }

        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken annotation = method.getAnnotation(UserLoginToken.class);
            if (annotation.required()) {
                if (token == null) {
                    throw new RuntimeException("无权限，请重新登陆");
                }
            }
            Integer userId = Integer.parseInt(JWT.decode(token).getAudience().get(0));
            TestUser user = userService.getUserById(userId);
            if (user == null) {
                throw new RuntimeException("用户不存在，请注册");
            }
            JWTVerifier build = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
            build.verify(token);
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");
    }
}
