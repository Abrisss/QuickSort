import algorithm.QuickSort;
import utility.MyArrayList;

public class Main {

    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(8);
        myArrayList.add(3);
        myArrayList.add(7);
        myArrayList.add(5);
        myArrayList.add(6);
        myArrayList.add(6);
        myArrayList.add(6);
        myArrayList.add(6);
        myArrayList.add(6);
        myArrayList.add(6);
        myArrayList.add(9);
        myArrayList.add(9);
        myArrayList.add(9);
        myArrayList.add(4);
        myArrayList.add(10);

        QuickSort quickSort = new QuickSort();
        MyArrayList<Integer> myArrayList1 = quickSort.sort(myArrayList);

        myArrayList1.forEach(System.out::println);
    }
}