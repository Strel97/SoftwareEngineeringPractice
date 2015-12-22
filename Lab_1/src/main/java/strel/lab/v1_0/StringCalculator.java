package strel.lab.v1_0;

/**
 * Created by —ергей on 24.11.2015.
 */
public class StringCalculator {
    /**
     *  The method can take 0, 1 or 2 numbers, and will return their sum
     *  (for an empty string it will return 0) for example УФ or У1Ф or У1,2Ф.
     *
     * @param numbers   Numbers to sum
     * @return          The sum of numbers
     */
    public int add(String numbers) {
        int sum = 0;    // Sum of numbers.
        int cnt = 0;    // Var to measure summed numbers. Max number of operands is 3.
        String[] nums = numbers.split(",");

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
}
