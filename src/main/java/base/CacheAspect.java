package base;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Aspect
public class CacheAspect {
    @Around("@annotation(base.anno.Cache)")
    public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("run");
        return joinPoint.proceed();
    }
}
