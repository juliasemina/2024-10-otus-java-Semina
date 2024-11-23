package ru.otus.homework;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.homework.test_framework.annotation.After;
import ru.otus.homework.test_framework.annotation.Before;
import ru.otus.homework.test_framework.annotation.Test;
import ru.otus.homework.test_framework.exception.TestException;

public class TestAnnotations {

    private static final Logger logger = LoggerFactory.getLogger(TestAnnotations.class);

    @Before
    public static void beforeTest() {
        logger.info("Start: BEFORE completed");
    }

    @After
    public static void afterTest() {
        logger.info("Finish: AFTER completed");
    }

    @Test
    public void anyTest1() {
        logger.info("testAnnotations.Test 1 completed: TEST 1");
    }

    @Test
    public void anyTest2() {
        logger.info("testAnnotations.Test 2 completed: TEST 2");
    }

    @Test
    public void anyTest3() {
        throw new TestException("Failed test");
    }
}
