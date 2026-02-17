import SortingAlgorithms.*;


class Tester {
    String name;
    String filename;
    Sorter<Integer> sortingAlgorithm;

    public Tester(Sorter<Integer> sorter, String name, String filename) {
        this.name = name;
        this.filename = filename;
        this.sortingAlgorithm = sorter;
    }

    public long singleTest() {
        Integer[] unsortedArray = Utils.readData(filename);

        long start = System.currentTimeMillis();
        sortingAlgorithm.sort(unsortedArray);
        long end = System.currentTimeMillis();
        
        return end - start;
    }

    public void multiTest(int repeats) {
        long[] results = new long[repeats];

        System.out.println("Running test for: " + name);
        System.out.println("Using: " + filename);

        for (int i = 0; i < repeats; i++) {
            long result = singleTest();
            System.out.println("Test #" + (i + 1) + ": " + result + "ms");            
            results[i] = result;
        }

        long total = 0;
        for (long l : results) {
            total += l;
        }

        long average = total / results.length;
        System.out.println("Average: " + average + "ms\n");
    }
}


public class RunTime<T> {
    private static final String FILE_PATH = "AssessedExerciseOne/data/intBig.txt";

    public static void main(String[] args) {
        Utils comparator = new Utils();

        Tester threeWay = new Tester(new ThreeWayQuicksort<Integer>(comparator)
        , "Three way quicksort", FILE_PATH);

        Tester medianOfThree = new Tester(new MedianOfThreeQuicksort<Integer>(comparator)
        , "Median of three quicksort", FILE_PATH);

        medianOfThree.multiTest(5);
        threeWay.multiTest(5);
    }
}
