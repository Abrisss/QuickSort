import algorithm.QuickSort;
import gui.MainFrame;
import utility.MyArrayList;
import utility.MyNumber;
import utility.NumberReader;

public class Main {

    public static void main(String[] args) {
//        NumberReader numberReader = new NumberReader();
//        MyArrayList<MyNumber> myArrayList = numberReader.parseNumbers("numbers");
//
//        QuickSort quickSort = new QuickSort();
//        for (Object object : quickSort.sort(myArrayList)) {
//            MyNumber myNumber = (MyNumber) object;
//            System.out.println(myNumber.getValue());
//
//        }

        NumberReader numberReader = new NumberReader();
        MainFrame mainFrame = new MainFrame(numberReader);
    }
}