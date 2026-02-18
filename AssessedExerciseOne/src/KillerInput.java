public class KillerInput {
    public static Integer[] generateMedianOfThree(int n) {
        // This kills MedianOfThree because
        // We need to ensure the first, middle and last elements
        // contain two small and one large (or vice versa)
        // which results in median of three making *very* large partitions
        // so for each recursion level we get:
        // T(n) = T(n - 1) + O(n)
        // T(0) = O(1)
        // which leads on to...
        // T(n) = O(n^2) + O(n)
        // = O(n)
        
        Integer[] output = new Integer[n];

        int mid = (n - 1) / 2;

        for (int i = 0; i <= mid; i++) {
            output[i] = i + 1;
        }

        int val = mid;
        for (int i = mid + 1; i < n; i++) {
            output[i] = val--;
        }

        return output;
    } 
    
    public static void main(String[] args) {
        Integer[] array = generateMedianOfThree(10);
        Utils.printArr(array);
    }
}
