package google.codejam.qualification_round_2021.reversort;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;

//class OriginalSolution {
//    private static String dest = "src/google/codejam2020/vestigium/";
//    private static String inputFileName = "reversort_sample_ts1_input.txt";
//    private static String outputFileName = "reversort_sample_ts1_output-test.txt";
//    private static ClassLoader classLoader;
//
////    public Reversort() {
////        try {
////
////            File obj = new File(inputFileName);
////            Scanner scanner = new Scanner(obj);
////            String noOfInputs = scanner.nextLine();
////            StringBuilder output = new StringBuilder();
////
////            for( int i = 0 ; i < Integer.parseInt(noOfInputs) ; i++) {
////                int intLen = Integer.parseInt(scanner.nextLine());
////                String inputString = scanner.nextLine();
////                int[] numbers = Arrays.stream(inputString.split(" ")).mapToInt(Integer::parseInt).toArray();
////                String result = String.format("Case #%d: %d", i+1, sort(numbers));
////
////                System.out.println( result );
////                output.append(result);
////                output.append("\n");
////            }
////            scanner.close();
////
////            writeOutputToFile(output.toString());
////
////        } catch(Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//
//
//    private static void writeOutputToFile(String str) {
//        Path file = Paths.get(outputFileName);
//        try {
//            Files.write(file, str.getBytes());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

//public class SubmittedOriginalSolution {
//    public static void maina(String[] args) {
////        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
////        int t = in.nextInt();
////
////        for( int i = 0 ; i < t ; i++) {
////            int n = in.nextInt();
////            int[] numbers = new int[n];
////
////            for( int j = 0 ; j < n-1 ; i++ ) {
////                 numbers[j] = in.nextInt();
////            }
////
//////            String inputString = in.nextLine();
//////            numbers = Arrays.stream(inputString.split(" ")).mapToInt(Integer::parseInt).toArray();
////
////            System.out.println("Case #" + i+1 +": "+ sort(numbers));
////        }
//
//        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
//        for (int i = 1; i <= t; ++i) {
//            int n = in.nextInt();
//
////            int m = in.nextInt();
//            int[] numbers = new int[n];
//
//            for( int j = 0 ; j < n-1 ; i++ ) {
//                numbers[j] = in.nextInt();
//                System.out.println( numbers[j] );
//            }
//
//
////            System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
//        }
//        in.close();
//    }

//    public static void main(String[] args) throws FileNotFoundException {
//        String dest = "src/google/codejam2020/vestigium/";
//        final boolean DEBUG = true;
//        long beginTime = System.nanoTime();
//        final String inputFile = dest + "ts1_input.txt";
//
//        try  {
//            InputStream is = DEBUG ? new FileInputStream( inputFile ) : System.in;
//            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
//            int testCount = scanner.nextInt();
//
//            for (int testNumber = 0; testNumber < testCount; ++testNumber) {
//
////                System.out.println(testNumber);
//
//                int sequence = scanner.nextInt();
////                System.out.println(sequence);
//
//                int[] numbers = new int[sequence];
//
//                for (int i = 0; i < sequence; ++i) {
//                    numbers[i] = scanner.nextInt();
////                    System.out.println(numbers[i]);
//                }
//                int cost = sort(numbers);
//                System.out.println("Case #" + (testNumber+1) + ": " + cost);
//            }
//
//            scanner.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
//    }
//
//    public static void mainSubmitted(String[] args) throws FileNotFoundException {
//        try  {
//            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
//            int testCount = scanner.nextInt();
//
//            for (int testNumber = 0; testNumber < testCount; ++testNumber) {
//                int sequence = scanner.nextInt();
//                int[] numbers = new int[sequence];
//
//                for (int i = 0; i < sequence; ++i) {
//                    numbers[i] = scanner.nextInt();
//                }
//                int cost = sort(numbers);
//                System.out.println("Case #" + (testNumber+1) + ": " + cost);
//            }
//
//            scanner.close();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static int sort(int [] a) {
//
//
//        int n = a.length;
//        int count=0;
//
//        if ( n == 2 ) {
//            return 1;
//        }
//
//        for (int i = 0; i < n-1; i++) {
//            int min = i;
//            int j = i+1;
//            count += j-i+1;
//
//            for (; j < n-1; j++) {
//                if (less(a[j], a[min])) {
//                    min = j;
//                }
//            }
//            exch(a, i, min);
//        }
//
//        return count;
//    }
//
//    private static void exch(int[] a, int i, int j) {
//        int swap = a[i];
//        a[i] = a[j];
//        a[j] = swap;
//    }
//
//    private static boolean less(int v, int w) {
//        return v < w ? true:false;
//    }
//}

public class Solution {

   private static int findMinIndex(int[] elements, int begin, int end) {
        int minIndex = begin;
        for (int i = begin; i < end; i++)
            if (elements[i] < elements[minIndex])
                minIndex = i;
        return minIndex;
    }

    private static void reverse(int[] elements, int begin, int count) {
        for (int i = 0; i < count / 2; i++) {
            int t = elements[i + begin];
            elements[i + begin] = elements[count - i - 1 + begin];
            elements[count - i - 1 + begin] = t;
        }
    }

    private static int getCost(int[] elements) {
        int cost = 0;
        for (int i = 0; i < elements.length - 1; i++) {
            int j = findMinIndex(elements, i, elements.length);
            int reverseCount = j - i + 1;
            reverse(elements, i, reverseCount);
            cost += reverseCount;
        }

        return cost;
    }

    private static void writeOutputToFile(String outputFileName, StringBuilder outputStr) {
        Path file = Paths.get(outputFileName);

        try {
            Files.write(file, outputStr.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(111);

        final boolean DEBUG = true;
        String DIR = "src/google/codejam/qualification_round_2021/reversort/";
        String inputFile = "test_data/test_set_1/ts1_input.txt";
        String outputFile = DIR + "test_data/output/ts1_output.txt";
        long beginTime = System.nanoTime();
        StringBuilder output = new StringBuilder();

        try {
            InputStream is = DEBUG ? new FileInputStream(DIR + inputFile) : System.in;
            Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)));
            int testCount = scanner.nextInt();

            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int elementCount = scanner.nextInt();
                int[] elements = new int[elementCount];

                for (int i = 0; i < elementCount; i++)
                    elements[i] = scanner.nextInt();

                int cost = getCost(elements);
                String outputString =  "Case #" + testNumber + ": " + cost;

                output.append(outputString);
                output.append("\n");
                System.out.println(outputString);
            }

            scanner.close();

            writeOutputToFile(outputFile, output);
            System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testMe() {
        System.out.println(111);
    }
}