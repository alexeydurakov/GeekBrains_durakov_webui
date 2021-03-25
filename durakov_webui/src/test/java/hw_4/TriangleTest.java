package hw_4;

import hw_4.Triangle;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTest {
    Triangle triangle;
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAllTests() {
        logger.info("Before all tests");
    }

    @BeforeEach
    public void setUp(){
        logger.info("Test begins!");
    }

    // тест на создание класса
    @Test
    void canBeInitializedTest() {
        triangle = new Triangle(15, 20, 25);
    }

    // тест - стороны положительные
    @Test
    void isPositiveSidesTest(){
        boolean result = triangle.isPositive(15, 20, 25);
        Assertions.assertTrue(result);
    }
    //тест - стороны не 0
    @Test
    void isNotNullTest(){
        boolean result = triangle.isNotNull(15, 20, 25);
        Assertions.assertTrue(result);
    }
    //тест - длины сторон позволяют построить треугольник
    @Test
    void isTriangleTest(){
        boolean result = triangle.isTriangle(15,20,25);
        Assertions.assertTrue(result);
    }

    @AfterEach
    public void tearDown(){
        logger.info("Test completed!");
    }

    @AfterAll
    static void afterAllTests() {
        logger.info("After all tests");
    }


}
