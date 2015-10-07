package algorithm;

import utility.MyArrayList;
import utility.MyNumber;

import java.util.Random;


/**
 * Created by Abraham on 2015. 10. 01..
 */
public class QuickSort {
    int number;
    MyArrayList<MyNumber> numbers;
    MyArrayList<MyArrayList<MyNumber>> allState;

    public QuickSort() {
        allState = new MyArrayList<>();
    }

    public MyArrayList sort(MyArrayList<MyNumber> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return null;
        }


        this.numbers = numbers;
        number = numbers.size();
        quickSort(0, number - 1);
        return numbers;
    }

    public void quickSort(int low, int high) {
        int i = low;
        int j = high;



        // A pivot elem véletlen kiválasztása.
        int randomValue = new Random().nextInt(high);
        Integer pivot = numbers.get(randomValue).getValue();

        numbers.get(i).setIsI(true);
        numbers.get(j).setIsJ(true);
        numbers.get(randomValue).setIsPivot(true);
        allState.add(numbers);


        // Két listára bontás
        while (i <= j) {

            // Ha a jelenlegi elem a bal listából kisebb, mint a pivot, akkor menjünk a következõ elemre a bal listában
            while (numbers.get(i).getValue() < pivot) {
                i++;
                numbers.get(i-1).setIsI(false);
                numbers.get(i).setIsI(true);
                allState.add(numbers);
            }

            // Ha a jelenlegi elem a jobb listából nagyobb, mint a pivot, akkor menjünk a következõ elemre a jobb listában
            while (numbers.get(j).getValue() > pivot) {
                j--;
                numbers.get(j-1).setIsJ(false);
                numbers.get(j).setIsJ(true);
                allState.add(numbers);
            }

            //Ha találtunk egy elemet a bal listában, ami nagyobb, mint a pivot, és egy elemet a jobb listában, ami
            // kisebb, mint a pivot, akkor kicseréljük ezeket az elemeket, és megnöveljük i-t és j-t.
            if (i <= j) {
                numbers.swap(i, j);

                numbers.get(i).setIsI(false);
                numbers.get(j).setIsJ(false);
                numbers.get(randomValue).setIsPivot(false);
                allState.add(numbers);

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

    public MyArrayList<MyArrayList<MyNumber>> getAllState() {
        return allState;
    }
}
