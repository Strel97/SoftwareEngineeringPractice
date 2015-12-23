package strel.lab.v1_4;

import java.util.ArrayList;

/**
 * Created by ������ on 24.11.2015.
 */
public class StringCalculator {
    /**
     *  The method can take 0, 1 or 2 numbers, and will return their sum
     *  (for an empty string it will return 0) for example �� or �1� or �1,2�.
     *  Delimiters between numbers are entered by user in such form: '//[delimiter]\n[numbers]'
     *
     *  Negatives are not allowed. If negative number occurs method returns -1.
     *
     * @param pattern   Numbers to sum
     * @return          The sum of numbers
     */
    public int add(String pattern) {

        String delimiter = determineDelimiter(pattern);
        String stringNumbers = getValues(pattern);

        ArrayList<Integer> numbers = parseNumbers(stringNumbers.split("[" + delimiter + "]"));

        try {
            checkNegative(numbers);
        }
        catch (Exception ex) {
            // Let's return -1 as operation
            // failed
            return -1;
        }

        int sum = 0;    // Sum of numbers.
        int cnt = 0;    // Var to measure summed numbers. Max number of operands is 3.

        for(int i = 0; i < numbers.size() && cnt != 3; i++) {
            sum += numbers.get(i);
            cnt++;
        }

        return sum;
    }

    public String determineDelimiter(String pattern) {
        String delimiter = "(,|\n)";
        if (pattern.matches("//.\n.*")) {
            // Complicated string :) First we divide our
            // pattern into numbers and delimiter section
            // and then take out delimiter.
            delimiter = pattern.split("\n")[0].substring(2);
        }

        return delimiter;
    }

    public String getValues(String pattern) {
        String numbers = pattern;
        if (pattern.matches("//.\n.*")) {
            numbers = pattern.split("\n")[1];
        }

        return numbers;
    }

    public ArrayList<Integer> parseNumbers(String[] stringNums) {
        ArrayList<Integer> nums = new ArrayList<Integer>();

        for (String str : stringNums) {
            try {
                nums.add( Integer.parseInt(str) );
            }
            catch (NumberFormatException ex) {
                // System.err.println("ERROR: Illegal number, skip it...");
            }
        }

        return nums;
    }

    public boolean checkNegative(ArrayList<Integer> nums)
        throws Exception
    {
        boolean hasNegative = false;
        ArrayList<Integer> negativeNums = new ArrayList<Integer>();

        for (Integer num : nums) {
            if (num < 0) {
                try {
                    negativeNums.add(num);
                    hasNegative = true;
                } catch (NumberFormatException ex) {
                }
            }
        }

        if (hasNegative)
            throw new Exception("Negatives are not allowed: " + negativeNums);

        return hasNegative;
    }


    public static void main(String[] args) {
        StringCalculator calc = new StringCalculator();

        System.out.println("First test '//,\\n2,4,5': result = " + calc.add("//,\n2,4,5"));
        System.out.println("Second test '//.\\n2.d0.5,7. 4': result = " + calc.add("//.\n2.d0.5,7. 4"));
        System.out.println("Third test '// \\nw s d': result = " + calc.add("// \nw s d"));
        System.out.println("Fourth test 'w,s,d,3,4': result = " + calc.add("w,s,d,3,4"));
        System.out.println("Fifth test '': result = " + calc.add(""));
        System.out.println("Six test '///\\n//3/4/5,6/': result = " + calc.add("///\n//3/4/5,6/"));
        System.out.println("Seventh test '///\\n//-3/-4/5,6/': result = " + calc.add("///\n//-3/-4/5,6/"));
    }
}
