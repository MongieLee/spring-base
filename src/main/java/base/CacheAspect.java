package base;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Configuration
@Aspect
public class CacheAspect {
    final RedisTemplate<String, Object> redisTemplate;
    private Map<String, Object> cache = new HashMap<>();

    public CacheAspect(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Around("@annotation(base.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        Object cachedValue = cache.get(methodName);
        if (cachedValue != null) {
            System.out.println("有缓存，旧的值");
            System.out.println(cachedValue);
            return cachedValue;
        } else {
            System.out.println("没有缓存，新的值");

            Object proceed = joinPoint.proceed();
            Object realValue = cache.put(methodName, proceed);
            System.out.println(proceed);
            return proceed;
        }
    }
}
