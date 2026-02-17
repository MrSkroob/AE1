package SortingAlgorithms;
import java.util.Comparator;

// public interface Sorter<T> {
//     void swap(T[] array, int index0, int index1) {

//     }
//     void sort(T[] array, Comparator<? super T> comparator);
// }


public abstract class Sorter<T> {
    Comparator<? super T> comparator;

    public Sorter(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public static <T> void swap(T[] array, int index0, int index1) {
        T temp = array[index1];
        array[index1] = array[index0];
        array[index0] = temp;
    }

    // <? super T> means that the type must be a *superclass* of T.
    public abstract void sort(T[] array);
}