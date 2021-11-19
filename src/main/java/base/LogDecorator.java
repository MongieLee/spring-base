package base;

import base.service.DataService;
import base.service.DataServiceImpl;

public class LogDecorator implements DataService {
    DataService delegate;

    public LogDecorator(DataService delegate) {
        this.delegate = delegate;
    }


    @Override
    public String a(int i) {
        System.out.println("a is invoked" + 1);
        return delegate.a(i);
    }

    @Override
    public String b(int i) {
        System.out.println("b is invoked" + 1);
        return delegate.b(i);
    }
}
