package SortingAlgorithms;
import java.util.Comparator;


public class ThreeWayQuicksort<T> extends Sorter<T> {
    public ThreeWayQuicksort(Comparator<? super T> comparator) {
        super(comparator);
    }

    private void algorithm(T[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        T pivot = array[lo];
        int lt = lo;
        int gt = hi;

        int i = lo + 1;

        while (i <= gt) {
            if (comparator.compare(array[i], pivot) < 0) {
                swap(array, lt, i);
                lt++;
                i++;
            }
            else if (comparator.compare(array[i], pivot) > 0) {
                swap(array, i, gt);
                gt--;
            }
            else {
                i++;
            }
        }
        algorithm(array, lo, lt - 1);
        algorithm(array, gt + 1, hi);
    }

    @Override
    public void sort(T[] array) {
        algorithm(array, 0, array.length - 1);
    }
}
