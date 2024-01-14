package ru.otus;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class Ioc {
    private Ioc() {}

    static TestLoggingInterface createLogging() {
        InvocationHandler handler = new LoggingInvocationHandler(new TestLogging());
        return (TestLoggingInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(), new Class<?>[] {TestLoggingInterface.class}, handler);
    }

    static class LoggingInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface loggingInterface;

        LoggingInvocationHandler(TestLoggingInterface loggingInterface) {
            this.loggingInterface = loggingInterface;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if (method.isAnnotationPresent(Log.class)) {
                System.out.println("executed method: " + method.getName() + " params:");
                for (Object arg : args) {
                    System.out.print(arg.toString());
                }
            }
            return method.invoke(loggingInterface, args);
        }

        @Override
        public String toString() {
            return "LoggingInvocationHandler{" + "loggingInterface=" + loggingInterface + '}';
        }
    }



}
