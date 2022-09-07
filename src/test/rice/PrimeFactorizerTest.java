package test.rice;

import main.rice.PrimeFactorizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * A test suite for the PrimeFactorizer class. Every method with the annotation "@Test"
 * will be called when running the test with JUnit.
 */
public class PrimeFactorizerTest {

    /**
     * A prime factorizer with an upper bound of 100.
     */
    private static final PrimeFactorizer factorizer100 = new PrimeFactorizer(100);

    /**
     * Tests that attempting factorization of a negative number rightfully returns null.
     */
    @Test
    void testFactorizeNegative() {
        int[] actual = factorizer100.computePrimeFactorization(-1);
        assertNull(actual);
    }

    @Test
    void testFactorize0() {
        int[] actual = factorizer100.computePrimeFactorization(0);
        assertNull(actual);
    }

    @Test
    void testFactorize1() {
        int[] actual = factorizer100.computePrimeFactorization(1);
        assertNull(actual);
    }

    @Test
    void testFactorize2() {
        int[] actual = factorizer100.computePrimeFactorization(2);
        int[] expected = new int[]{2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFactorize3() {
        int[] actual = factorizer100.computePrimeFactorization(3);
        int[] expected = new int[]{3};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFactorize10() {
        int[] actual = factorizer100.computePrimeFactorization(10);
        int[] expected = new int[]{2, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFactorize8() {
        int[] actual = factorizer100.computePrimeFactorization(8);
        int[] expected = new int[]{2, 2, 2};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFactorize101() {
        int[] actual = factorizer100.computePrimeFactorization(101);
        assertNull(actual);
    }

    @Test
    void testFactorize102() {
        int[] actual = factorizer100.computePrimeFactorization(102);
        assertNull(actual);
    }

    @Test
    void testFactorize97() {
        int[] actual = factorizer100.computePrimeFactorization(97);
        int[] expected = new int[]{97};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFactorize100() {
        int[] actual = factorizer100.computePrimeFactorization(100);
        int[] expected = new int[]{2, 2, 5, 5};
        assertArrayEquals(expected, actual);
    }

    private static final PrimeFactorizer factorizer20000 = new PrimeFactorizer(20000);
    @Test
    void testFactorize19997() {
        int[] actual = factorizer20000.computePrimeFactorization(19997);
        int[] expected = new int[]{19997};
        assertArrayEquals(expected, actual);
    }

    @Test
    void testFactorize20000() {
        int[] actual = factorizer20000.computePrimeFactorization(20000);
        int[] expected = new int[]{2, 2, 2, 2, 2, 5, 5, 5, 5};
        assertArrayEquals(expected, actual);
    }
}