package SortingAlgorithms;
import java.util.Comparator;


public class MedianOfThreeQuicksort<T> extends Sorter<T> {
    public MedianOfThreeQuicksort(Comparator<? super T> comparator) {
        super(comparator);
    }

    private int lomutoPartition(T[] array, int lo, int hi) {
        T pivot = array[hi];
        int i = lo;

        for (int j = lo; j < hi - 1; j++) {
            if (comparator.compare(array[j], pivot) <= 0) {
                swap(array, i, j);
                i++;
            }
        }
        swap(array, i, hi);
        return i;
    }

    private int medianOfThree(T[] array, int lo, int hi) {
        int mid = (lo + hi) / 2;
        if (comparator.compare(array[lo], array[mid]) > 0) swap(array, lo, mid);
        if (comparator.compare(array[mid], array[hi]) > 0) swap(array, hi, mid);
        if (comparator.compare(array[lo], array[mid]) > 0) swap(array, lo, mid);
        return mid;
    }
    
    private void algorithm(T[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = medianOfThree(array, lo, hi);
        swap(array, mid, hi);

        int p = lomutoPartition(array, lo, hi);
        algorithm(array, lo, p - 1);
        algorithm(array, p + 1, hi);
    }

    @Override
    public void sort(T[] array) {
        algorithm(array, 0, array.length - 1);
    }
}
