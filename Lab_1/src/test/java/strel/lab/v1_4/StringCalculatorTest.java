package strel.lab.v1_4;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by Сергей on 23.12.2015.
 */
public class StringCalculatorTest extends TestCase {

    private static final StringCalculator calc = new StringCalculator();


    @Test
    public void testAdd() throws Exception {
        System.out.println("First test '//,\\n2,4,5': result = " + calc.add("//,\n2,4,5"));
        assertTrue(calc.add("//,\n2,4,5") == 11);

        System.out.println("Second test '//.\\n2.d0.5,7. 4': result = " + calc.add("//.\n2.d0.5,7. 4"));
        assertTrue(calc.add("//.\n2.d0.5,7. 4") == 2);

        System.out.println("Third test '// \\nw s d': result = " + calc.add("// \nw s d"));
        assertTrue(calc.add("// \nw s d") == 0);

        System.out.println("Fourth test 'w,s,d,3,4': result = " + calc.add("w,s,d,3,4"));
        assertTrue(calc.add("w,s,d,3,4") == 7);

        System.out.println("Fifth test '': result = " + calc.add(""));
        assertTrue(calc.add("") == 0);

        System.out.println("Six test '///\\n//3/4/5,6/': result = " + calc.add("///\n//3/4/5,6/"));
        assertTrue(calc.add("///\n//3/4/5,6/") == 7);

        System.out.println("Seventh test '///\\n//-3/4/-5,6/': result = " + calc.add("///\n//-3/4/-5,6/"));
        assertTrue(calc.add("///\n//-3/4/-5,6/") == -1);
    }
}