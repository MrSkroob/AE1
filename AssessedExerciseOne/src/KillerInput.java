public class KillerInput {
    public static Integer[] generateMedianOfThree(int n) {
        // This kills MedianOfThree because
        // the pivot is guaranteed to be the greatest item.
        // this results in every item needing to be swapped
        // to its right. 
        // if we then move to the next pivot (lo + 1)
        // then every item except for the original pivot needing to be swapped
        // hey, doesn't this sound familiar to bubblesort?
        
        Integer[] output = new Integer[n];

        for (int i = 0; i < n; i++) {
            output[i] = n - i - 1;
        }

        return output;
    } 
    
    public static void main(String[] args) {
        Integer[] array = generateMedianOfThree(5);
        Utils.printArr(array);
    }
}
