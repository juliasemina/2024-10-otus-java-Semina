package ru.otus.homework.test_framework;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.otus.homework.test_framework.exception.TestException;

public final class TestUtils {

    private static final Logger logger = LoggerFactory.getLogger(TestUtils.class);

    private TestUtils() {}

    public static <T> T newInstanceTestClass(Class<T> clazz) {

        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            logger.error("Can't create new instance class");
            throw new TestException("Can't create new instance class");
        }
    }

    public static <T> void runMethod(Method testMethod, T clazz)
            throws InvocationTargetException, IllegalAccessException {

        testMethod.invoke(clazz);
    }

    public static <T> void runMethods(List<Method> methods, T clazz) throws TestException {
        methods.forEach(m -> {
            try {
                m.invoke(clazz);
            } catch (Exception e) {
                logger.error("Invoke method error, name: {}, message: {}", m.getName(), e.getMessage());
                throw new TestException("Invoke method method error");
            }
        });
    }

    public static <T> List<Method> getAllMethods(Class<T> clazz) {

        return Arrays.asList(clazz.getDeclaredMethods());
    }

    public static <T extends Annotation> List<Method> filterMethodsByAnnotation(
            List<Method> methods, Class<T> annotation) {

        return methods.stream().filter(m -> m.isAnnotationPresent(annotation)).toList();
    }
}
