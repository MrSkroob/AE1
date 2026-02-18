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

        long start = System.nanoTime();
        sortingAlgorithm.sort(unsortedArray);
        long end = System.nanoTime();
        
        return (long) ((end - start) / 10e6);
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
    private static final String[] FILE_PATHS = {"AssessedExerciseOne/data/intBig.txt", "AssessedExerciseOne/data/Dutch.txt"};

    public static void main(String[] args) {
        Utils comparator = new Utils();

        for (String filePath : FILE_PATHS) {
            Tester threeWay = new Tester(new ThreeWayQuicksort<Integer>(comparator)
            , "Three way quicksort", filePath);

            Tester medianOfThree = new Tester(new MedianOfThreeQuicksort<Integer>(comparator)
            , "Median of three quicksort", filePath);

            Tester insertion = new Tester(new InsertionSort<Integer>(comparator)
            , "Insertion sort", filePath);

            insertion.multiTest(5);
            medianOfThree.multiTest(5);
            threeWay.multiTest(5);
        }        
    }
}
