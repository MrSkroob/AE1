import SortingAlgorithms.MedianOfThreeQuicksort;
import SortingAlgorithms.ThreeWayQuicksort;


public class Part1 {
    public static void main(String[] args) throws Exception {
        Utils comparator = new Utils();
        Integer[] array = {41, 321, 415, 152, 5134};

        // Part 1.a
        // Implementation of a quick sort.
        ThreeWayQuicksort<Integer> sorter = new ThreeWayQuicksort<>(comparator);
        sorter.sort(array);

        // Part 1.b
        Integer[] dutchIntegers = Utils.readData("AssessedExerciseOne/data/Dutch.txt");
        MedianOfThreeQuicksort<Integer> sorter2 = new MedianOfThreeQuicksort<>(comparator);
        sorter2.sort(dutchIntegers);
        // For the tests, please see RunTime.java
        
        // For Part 1.c, please see: KillerInput.java
    }
}
