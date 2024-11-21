package ru.otus.homework;

import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.homework.test_framework.TestResult;
import ru.otus.homework.test_framework.TestRunner;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        Set<TestResult> testResult =
                Set.of(TestRunner.runTest(TestAnnotations.class), TestRunner.runTest(TestAnnotations2.class));

        logger.info("Tests finished: result: {}", testResult);
    }
}
