import SortingAlgorithms.*;


class Solution {
    // The planned algorithm will make use of both quick sort and insertion sort.
    // It will initially sort using some form of efficient sorting algorithm, 
    // Then later on periodically sort using insertion sort.
    // Why?
    // It is reasonable to assume that over time that order would not change by much.
    // For nearly sorted arrays, insertion sort is really fast O(n)!
    
    Integer[] videos; // the list of videos (we'll use intBig to simulate views)
    InsertionSort<Integer> sorter;
    Boolean isSorted;

    public Solution() {
        this.videos = Utils.readData("AssessedExerciseOne/data/intBig.txt"); 
        ThreeWayQuicksort<Integer> initialSorter = new ThreeWayQuicksort<>((Integer a, Integer b) -> a.compareTo(b));
        this.sorter = new InsertionSort<>((Integer a, Integer b) -> a.compareTo(b));

        initialSorter.sort(videos);
        this.isSorted = true;
    }

    public Integer[] getTopFive() {
        Integer[] topFive = new Integer[5];

        if (!isSorted) {
            sorter.sort(videos);
            this.isSorted = true;
        }

        for (int i = topFive.length - 1; i > -1 && i > (topFive.length - 1) - 5; i--) {
            int j = videos.length - i;
            topFive[i] = videos[j - 1];
        }

        return topFive;
    }
}


public class Part2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Utils.printArr(solution.getTopFive());
    }
}
