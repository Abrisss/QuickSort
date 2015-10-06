import algorithm.QuickSort;
import utility.MyArrayList;
import utility.NumberReader;

public class Main {

    public static void main(String[] args) {
        NumberReader numberReader = new NumberReader();
        MyArrayList<Integer> myArrayList = numberReader.parseNumbers("numbers");

        QuickSort quickSort = new QuickSort();
        quickSort.sort(myArrayList).forEach(System.out::println);
    }
}