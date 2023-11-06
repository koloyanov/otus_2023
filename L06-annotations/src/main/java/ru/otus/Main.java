package ru.otus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        startTests(TestClass.class);
    }

    public static <T> void startTests(Class<T> clazz) throws Exception {
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> beforeMethods = new ArrayList<>();
        List<Method> testMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();
        Object instance = clazz.getDeclaredConstructor().newInstance();
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

        try {
            for (Method method : beforeMethods) {
                method.invoke(instance);
            }
            for (Method method : testMethods) {
                try {
                    method.invoke(instance);
                    passedTests++;
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                    failedTests++;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            for (Method method : afterMethods) {
                method.invoke(instance);
            }
        }

        System.out.println(clazz.getName() + " tests was ended");
        System.out.println("Test counter: " + testMethods.size());
        System.out.println("Passed tests: " + passedTests + ", failedTests: " + failedTests);
    }
}