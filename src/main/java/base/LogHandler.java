package base;

import base.service.DataService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class LogHandler implements InvocationHandler {
    DataService delegate;

    public LogHandler(DataService delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + "参数" + Arrays.toString(args));
        Object invoke = method.invoke(delegate, args);
        System.out.println(invoke);
        return invoke;
    }
}
