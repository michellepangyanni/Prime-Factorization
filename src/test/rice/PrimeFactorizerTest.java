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
    /**
     * Tests that attempting factorization of a 0 returns null.
     */
    @Test
    void testFactorize0() {
        int[] actual = factorizer100.computePrimeFactorization(0);
        assertNull(actual);
    }
    /**
     * Tests that attempting factorization of a 1 returns null.
     */
    @Test
    void testFactorize1() {
        int[] actual = factorizer100.computePrimeFactorization(1);
        assertNull(actual);
    }
    /**
     * Tests with inputting a prime (>1) that can be factorized
     */
    @Test
    void testFactorize2() {
        int[] actual = factorizer100.computePrimeFactorization(2);
        int[] expected = new int[]{2};
        assertArrayEquals(expected, actual);
    }
    /**
     * Test with input's factorization includes more than one distinct prime
     */
    @Test
    void testFactorize3() {
        int[] actual = factorizer100.computePrimeFactorization(3);
        int[] expected = new int[]{3};
        assertArrayEquals(expected, actual);
    }

    /**
     * Test with the input is a composite (non-prime) that can be factorized
     */
    @Test
    void testFactorize10() {
        int[] actual = factorizer100.computePrimeFactorization(10);
        int[] expected = new int[]{2, 5};
        assertArrayEquals(expected, actual);
    }
    /**
     * Test with input's factorization includes repeats
     */
    @Test
    void testFactorize8() {
        int[] actual = factorizer100.computePrimeFactorization(8);
        int[] expected = new int[]{2, 2, 2};
        assertArrayEquals(expected, actual);
    }

    /**
     * The input is a prime that is too large to be factorized
     */
    @Test
    void testFactorize101() {
        int[] actual = factorizer100.computePrimeFactorization(101);
        assertNull(actual);
    }

    /**
     * The input is a composite that is too large to be factorized
     */
    @Test
    void testFactorize102() {
        int[] actual = factorizer100.computePrimeFactorization(102);
        assertNull(actual);
    }

    /**
     * The input is a prime (>1) that can be factorized
     */
    @Test
    void testFactorize97() {
        int[] actual = factorizer100.computePrimeFactorization(97);
        int[] expected = new int[]{97};
        assertArrayEquals(expected, actual);
    }

    /**
     * The input is the upper bound of PrimeFactorizer
     */
    @Test
    void testFactorize100() {
        int[] actual = factorizer100.computePrimeFactorization(100);
        int[] expected = new int[]{2, 2, 5, 5};
        assertArrayEquals(expected, actual);
    }

    /**
     * A prime factorizer with an upper bound of 20000
     */
    private static final PrimeFactorizer factorizer20000 = new PrimeFactorizer(20000);

    /**
     * The input is a very large (> 10000) prime that can be factorized
     */
    @Test
    void testFactorize19997() {
        int[] actual = factorizer20000.computePrimeFactorization(19997);
        int[] expected = new int[]{19997};
        assertArrayEquals(expected, actual);
    }

    /**
     * The input is a very large (> 10000) composite that can factorized
     */
    @Test
    void testFactorize20000() {
        int[] actual = factorizer20000.computePrimeFactorization(20000);
        int[] expected = new int[]{2, 2, 2, 2, 2, 5, 5, 5, 5};
        assertArrayEquals(expected, actual);
    }
}