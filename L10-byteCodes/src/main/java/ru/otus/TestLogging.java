package ru.otus;

public class TestLogging implements TestLoggingInterface {
    @Override
    @Log
    public void calculation(int param) {
        System.out.println("param is: " + param);
    }
    @Override
    public String toString() {
        return "TestLogging{}";
    }

}
