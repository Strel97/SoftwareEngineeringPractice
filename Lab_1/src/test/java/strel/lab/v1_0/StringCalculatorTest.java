package strel.lab.v1_0;

import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

/**
 * Created by Сергей on 24.11.2015.
 */
public class StringCalculatorTest extends TestCase {

    private static final StringCalculator calc = new StringCalculator();


    @Test
    public void testAdd() throws Exception {
        System.out.println("First test '2,4,5': result = " + calc.add("2,4,5"));
        assertTrue(calc.add("2,4,5") == 11);

        System.out.println("Second test '2,d0,5,7, 4': result = " + calc.add("2,d0,5,7, 4"));
        assertTrue(calc.add("2,d0,5,7, 4") == 14);

        System.out.println("Third test 'w,s,d': result = " + calc.add("w,s,d"));
        assertTrue(calc.add("w,s,d") == 0);

        System.out.println("Fourth test 'w,s,d,3,4': result = " + calc.add("w,s,d,3,4"));
        assertTrue(calc.add("w,s,d,3,4") == 7);

        System.out.println("Fifth test '': result = " + calc.add(""));
        assertTrue(calc.add("") == 0);
    }
}