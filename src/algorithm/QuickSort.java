package algorithm;

import utility.MyArrayList;

import java.util.Random;


/**
 * Created by Abraham on 2015. 10. 01..
 */
public class QuickSort {
    int number;
    MyArrayList<Integer> numbers;


    public MyArrayList sort(MyArrayList<Integer> numbers) {
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
        Integer pivot = numbers.get(new Random().nextInt(high));


        // Két listára bontás
        while (i <= j) {

            // Ha a jelenlegi elem a bal listából kisebb, mint a pivot, akkor menjünk a következõ elemre a bal listában
            while (numbers.get(i) < pivot) {
                i++;
            }

            // Ha a jelenlegi elem a jobb listából nagyobb, mint a pivot, akkor menjünk a következõ elemre a jobb listában
            while (numbers.get(j) > pivot) {
                j--;
            }

            //Ha találtunk egy elemet a bal listában, ami nagyobb, mint a pivot, és egy elemet a jobb listában, ami
            // kisebb, mint a pivot, akkor kicseréljük ezeket az elemeket, és megnöveljük i-t és j-t.
            if (i <= j) {
                numbers.swap(i, j);
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
}
