package ru.otus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class Ioc {
    private Ioc() {}

    static TestLoggingInterface createLogging() {
        InvocationHandler handler = new LoggingInvocationHandler(new TestLogging());
        return (TestLoggingInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(), new Class<?>[] {TestLoggingInterface.class}, handler);
    }

    static class LoggingInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface loggingInterface;
        private final Set<String> methods;

        LoggingInvocationHandler(TestLoggingInterface loggingInterface) {
            this.loggingInterface = loggingInterface;
            methods = new LinkedHashSet<>();
            for (Method method : TestLogging.class.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Log.class) && method.getParameterCount() == 1 && method.getParameterTypes()[0] == int.class) {
                    methods.add(method.getName());
                }
            }
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (methods.contains(method.getName())) {
                System.out.println("executed method: " + method.getName());
            }
            return method.invoke(loggingInterface, args);
        }

        @Override
        public String toString() {
            return "LoggingInvocationHandler{" + "loggingInterface=" + loggingInterface + '}';
        }
    }
}
