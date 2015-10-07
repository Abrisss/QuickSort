package algorithm;

import utility.MyArrayList;
import utility.MyNumber;

import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Abraham on 2015. 10. 01..
 */
public class QuickSort {
    int number;
    MyArrayList numbers;
    ArrayList<MyArrayList> allState;

    public QuickSort() {
        allState = new ArrayList<>();
    }

    public MyArrayList sort(MyArrayList numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return null;
        }


        this.numbers = numbers;
        number = numbers.size();
        quickSort(0, number - 1);
        return numbers;
    }

    public synchronized void quickSort(int low, int high) {
        int i = low;
        int j = high;



        // A pivot elem véletlen kiválasztása.
        int randomValue = new Random().nextInt(high);
        Integer pivot = numbers.get(randomValue).getValue();

        numbers.setI(i);
        numbers.setJ(j);
        numbers.setPivot(randomValue);
        allState.add(new MyArrayList(numbers));


        // Két listára bontás
        while (i <= j) {

            // Ha a jelenlegi elem a bal listából kisebb, mint a pivot, akkor menjünk a következõ elemre a bal listában
            while (numbers.get(i).getValue() < pivot) {
                i++;
                numbers.setI(i);
                allState.add(new MyArrayList(numbers));
            }

            // Ha a jelenlegi elem a jobb listából nagyobb, mint a pivot, akkor menjünk a következõ elemre a jobb listában
            while (numbers.get(j).getValue() > pivot) {
                j--;
                numbers.setJ(j);
                allState.add(new MyArrayList(numbers));
            }

            //Ha találtunk egy elemet a bal listában, ami nagyobb, mint a pivot, és egy elemet a jobb listában, ami
            // kisebb, mint a pivot, akkor kicseréljük ezeket az elemeket, és megnöveljük i-t és j-t.
            if (i <= j) {
                numbers.swap(i, j);
                allState.add(new MyArrayList(numbers));

                i++;
                j--;

            }
        }
        // Rekurzív
        if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
    }

    public ArrayList<MyArrayList> getAllState() {
        return allState;
    }
}
