package strel.lab.v1_3;

/**
 * Created by ������ on 24.11.2015.
 */
public class StringCalculator {
    /**
     *  The method can take 0, 1 or 2 numbers, and will return their sum
     *  (for an empty string it will return 0) for example �� or �1� or �1,2�.
     *  Delimiters between numbers are entered by user in such form: '//[delimiter]\n[numbers]'
     *
     * @param pattern   Numbers to sum
     * @return          The sum of numbers
     */
    public int add(String pattern) {

        String delimiter;
        String numbers;

        if (pattern.matches("//.\n.*")) {
            String[] splited = pattern.split("\n");
            delimiter = splited[0].substring(2);
            numbers = splited[1];
        }
        else {
            // If string doesn't define pattern
            // use comma as delimiter
            delimiter = "(,|\n)";
            numbers = pattern;
        }

        int sum = 0;    // Sum of numbers.
        int cnt = 0;    // Var to measure summed numbers. Max number of operands is 3.
        String[] nums = numbers.split("[" + delimiter + "]");

        for(int i = 0; i < nums.length && cnt != 3; i++) {
            try {
                sum += Integer.parseInt(nums[i]);
                cnt++;
            }
            catch (NumberFormatException ex) {
                // System.err.println("ERROR: Illegal number, skip it...");
            }
        }

        return sum;
    }


    public static void main(String[] args) {
        StringCalculator calc = new StringCalculator();

        System.out.println("First test '//,\\n2,4,5': result = " + calc.add("//,\n2,4,5"));
        System.out.println("Second test '//.\\n2.d0.5,7. 4': result = " + calc.add("//.\n2.d0.5,7. 4"));
        System.out.println("Third test '// \\nw s d': result = " + calc.add("// \nw s d"));
        System.out.println("Fourth test 'w,s,d,3,4': result = " + calc.add("w,s,d,3,4"));
        System.out.println("Fifth test '': result = " + calc.add(""));
        System.out.println("Six test '///\\n//3/4/5,6/': result = " + calc.add("///\n//3/4/5,6/"));
    }
}
