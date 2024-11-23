package ru.otus.homework.test_framework;

import ru.otus.homework.test_framework.exception.TestException;

public class TestResult {

    private final String className;
    private final int total;
    private int success;
    private int failed;

    public TestResult(String className, int total) {
        this.className = className;
        this.total = total;
    }

    public void incrementSuccess() {
        ++this.success;
    }

    public void incrementFailed() {
        ++this.failed;
    }

    public void checkResult() {

        if (this.total != Integer.sum(this.success, this.failed)) {
            throw new TestException(
                    ("Total test count does not match the count checked tests" + ": total: %s, success: %s, failed: %s")
                            .formatted(total, success, failed));
        }
    }

    @Override
    public String toString() {
        return "\n {className='" + className + '\'' + ", total="
                + total + ", success="
                + success + ", failed="
                + failed + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TestResult that)) {
            return false;
        }

        return className.equals(that.className);
    }

    @Override
    public int hashCode() {
        return className.hashCode();
    }
}
