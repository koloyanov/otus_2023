package ru.otus;

public class Main {
    public static void main(String[] args) {
        TestLoggingInterface logging = Ioc.createLogging();
        logging.calculation(10);
    }
}