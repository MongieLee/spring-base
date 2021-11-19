package base;

import base.service.DataService;
import base.service.DataServiceImpl;

import java.lang.reflect.Proxy;

public class Main {
    static DataService dataService = new CacheDecorator(new LogDecorator(new DataServiceImpl()));
    static DataService service = new DataServiceImpl();

    public static void main(String[] args) {
//        System.out.println(dataService.a(1));
//        System.out.println(dataService.a(1));
//        System.out.println(dataService.a(1));
//        System.out.println(dataService.a(1));
//        System.out.println(dataService.b(2));
//        System.out.println(dataService.b(2));
        DataService proxyInstance = (DataService) Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                new Class[]{DataService.class},
                new LogHandler(service));
        proxyInstance.a(1);
    }
}
