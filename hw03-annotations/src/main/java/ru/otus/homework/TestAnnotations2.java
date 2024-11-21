package ru.otus.homework;

import ru.otus.homework.test_framework.annotation.Test;
import ru.otus.homework.test_framework.exception.TestException;

public class TestAnnotations2 {
    @Test
    public void otherTest() {
        throw new TestException("Failed test");
    }
}
