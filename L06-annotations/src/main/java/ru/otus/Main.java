package ru.otus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Main main = new Main();

        List<String> testClasses = List.of("ru.otus.TestClass", "ru.otus.TestClassToo");

        for (String test : testClasses) {
            main.startTests(Class.forName(test));
        }
    }

    public void startTests(Class<?> clazz) throws Exception {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> beforeMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();
        int passedTests = 0;
        int failedTests = 0;

        Arrays.stream(methods)
                .filter(method -> method.getAnnotation(Before.class) != null)
                .forEach(beforeMethods::add);
        Arrays.stream(methods)
                .filter(method -> method.getAnnotation(Test.class) != null)
                .forEach(testMethods::add);
        Arrays.stream(methods)
                .filter(method -> method.getAnnotation(After.class) != null)
                .forEach(afterMethods::add);

        for (Method test : testMethods) {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            for (Method before : beforeMethods){
                before.invoke(instance);
            }
            try {
                test.invoke(instance);
                passedTests++;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                failedTests++;
            }
            for (Method after : afterMethods) {
                after.invoke(instance);
            }
        }

        System.out.println(clazz.getName() + " tests was ended");
        System.out.println("Test counter: " + testMethods.size());
        System.out.println("Passed tests: " + passedTests + ", failedTests: " + failedTests);
    }
}