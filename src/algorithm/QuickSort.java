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



        // A pivot elem v�letlen kiv�laszt�sa.
        int randomValue = new Random().nextInt(high);
        Integer pivot = numbers.get(randomValue).getValue();

        numbers.get(i).setIsI(true);
        numbers.get(j).setIsJ(true);
        numbers.get(randomValue).setIsPivot(true);
        allState.add(numbers);


        // K�t list�ra bont�s
        while (i <= j) {

            // Ha a jelenlegi elem a bal list�b�l kisebb, mint a pivot, akkor menj�nk a k�vetkez� elemre a bal list�ban
            while (numbers.get(i).getValue() < pivot) {
                i++;
                numbers.get(i-1).setIsI(false);
                numbers.get(i).setIsI(true);
                allState.add(numbers);
            }

            // Ha a jelenlegi elem a jobb list�b�l nagyobb, mint a pivot, akkor menj�nk a k�vetkez� elemre a jobb list�ban
            while (numbers.get(j).getValue() > pivot) {
                j--;
                numbers.get(j-1).setIsJ(false);
                numbers.get(j).setIsJ(true);
                allState.add(numbers);
            }

            //Ha tal�ltunk egy elemet a bal list�ban, ami nagyobb, mint a pivot, �s egy elemet a jobb list�ban, ami
            // kisebb, mint a pivot, akkor kicser�lj�k ezeket az elemeket, �s megn�velj�k i-t �s j-t.
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
        // Rekurz�v
        if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
    }

    public MyArrayList<MyArrayList<MyNumber>> getAllState() {
        return allState;
    }
}
