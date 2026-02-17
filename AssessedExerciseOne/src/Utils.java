import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Utils implements Comparator<Integer> {
    public static <T> void printArr(T[] array) {
        for (T t : array) {
            System.out.println(t);
        }
    }

    public static Integer[] readData(String filename) {
        ArrayList<Integer> numbers = new ArrayList<>();

        File file = new File(filename);
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                numbers.add(Integer.parseInt(data));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        Integer[] outputNumbers = new Integer[numbers.size()];
        // because java is... annoying to put it nicely, 
        // toArray returns Object[] which does not match with the 
        // method type. So we have to create an Integer[], then
        // pass that as a parameter. This sucks :(
        return numbers.toArray(outputNumbers);
    }

    @Override
    public int compare(Integer a, Integer b) {
        if (a > b) {
            return 1;
        }
        else if (a.equals(b)) {
            return 0;
        }
        return -1;
    }
}
