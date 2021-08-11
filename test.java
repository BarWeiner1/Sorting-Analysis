import java.util.Arrays;
/**
 * Template to create a test class
 * Tests FHSort's Quicksort using different recursion limits and arrays of different sizes
 */
public class test {

    private static final int INCREMENT_SIZE = 499000; //set increment interval to test different array sizes
    private static Integer[] testArr;
    private static double[][] testTimes = new double[150][21]; //to store run times;

    /**
     * Loops through different recursion limits and tests quicksort
     * Creates random arrays to test on
     * Finally prints out the results
     */
    public static void main(String[] args) {

        for (int i = 2; i <= 300; i = i + 2) {
            System.out.println(i);
            System.out.println("Recursion limit " + i);
            FHsort.setRecursionLimit(i);
            int arrSize = 20000;
            for (int j = 0; j <= 20; j++) {
                testArr = randomList(arrSize);
                long totalTime = 0;
                for (int k = 0; k < 3; k++) {
                    long startTime = System.currentTimeMillis();
                    FHsort.quickSort(testArr);
                    long stopTime = System.currentTimeMillis();
                    totalTime = (stopTime - startTime) + totalTime;
                }
                totalTime /= 3;
                testTimes[i / 2 - 1][j] = totalTime;
                arrSize += INCREMENT_SIZE;

            }
        }
        printRunTimes();
    }
    /**
     * Void method to print out all of the times
     * Takes in no parameters
     */
        public static void printRunTimes () {
            System.out.println("Times:");
            for (int i = 0; i < testTimes.length; i++) {
                System.out.println(Arrays.toString(testTimes[i]));
            }
        }
    /**
     * Method to create a random Integer[]
     * Takes in an int length
     */
    public static Integer[] randomList(int length){
        Integer[] random = new Integer[length];
        for (int i=0; i<length; i++){
            random[i] = ((int) (Math.random()*length));  //generates random number from 0 --> (length-1)
        }
        return random;
    }
    }

