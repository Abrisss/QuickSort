import algorithm.QuickSort;
import utility.MyArrayList;
import utility.NumberReader;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        NumberReader numberReader = new NumberReader();
        MyArrayList<Integer> myArrayList = (MyArrayList<Integer>)numberReader.parseNumbers("numbers");


        QuickSort quickSort = new QuickSort();
        MyArrayList<Integer> myArrayList1 = quickSort.sort(myArrayList);

        myArrayList1.forEach(System.out::println);
    }
}