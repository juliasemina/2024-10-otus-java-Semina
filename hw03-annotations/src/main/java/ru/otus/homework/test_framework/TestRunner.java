package ru.otus.homework.test_framework;

import java.lang.reflect.Method;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.homework.test_framework.annotation.After;
import ru.otus.homework.test_framework.annotation.Before;
import ru.otus.homework.test_framework.annotation.Test;

public class TestRunner {

    private static final Logger logger = LoggerFactory.getLogger(TestRunner.class);

    private TestRunner() {}

    public static <T> TestResult runTest(Class<T> clazz) {

        List<Method> allMethods = TestUtils.getAllMethods(clazz);

        List<Method> beforeMethods = TestUtils.filterMethodsByAnnotation(allMethods, Before.class);

        List<Method> afterMethods = TestUtils.filterMethodsByAnnotation(allMethods, After.class);

        List<Method> testMethods = TestUtils.filterMethodsByAnnotation(allMethods, Test.class);

        TestResult testResult = new TestResult(clazz.getSimpleName(), testMethods.size());

        for (Method method : testMethods) {
            T testClass = TestUtils.newInstanceTestClass(clazz);

            try {
                TestUtils.runMethods(beforeMethods, testClass);

                TestUtils.runMethod(method, testClass);

                TestUtils.runMethods(afterMethods, testClass);

                testResult.incrementSuccess();

            } catch (Exception e) {
                logger.error("Test method run error, {}", e.getMessage());
                testResult.incrementFailed();

            } finally {
                TestUtils.runMethods(afterMethods, testClass);
            }
        }

        testResult.checkResult();
        return testResult;
    }
}
