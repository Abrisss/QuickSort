package algorithm;

import utility.MyArrayList;

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



        // A pivot elem v�letlen kiv�laszt�sa.
        int randomValue = new Random().nextInt(high);
        Integer pivot = numbers.get(randomValue).getValue();

        numbers.setI(i);
        numbers.setJ(j);
        numbers.setPivot(randomValue);
        allState.add(new MyArrayList(numbers));


        // Ket listara bontas
        while (i <= j) {

            // Ha a jelenlegi elem a bal listabol kisebb, mint a pivot, akkor menjunk a kovetkezo elemre a bal listaban
            while (numbers.get(i).getValue() < pivot) {
                i++;
                numbers.setI(i);
                allState.add(new MyArrayList(numbers));
            }

            // Ha a jelenlegi elem a jobb listabal nagyobb, mint a pivot, akkor menjunk a kovetkezo elemre a jobb listaban
            while (numbers.get(j).getValue() > pivot) {
                j--;
                numbers.setJ(j);
                allState.add(new MyArrayList(numbers));
            }

            //Ha talaltunk egy elemet a bal listaban, ami nagyobb, mint a pivot, es egy elemet a jobb listaban, ami
            // kisebb, mint a pivot, akkor kicseruljuk ezeket az elemeket, es megnoveljuk i-t es j-t.
            if (i <= j) {
                numbers.swap(i, j);
                allState.add(new MyArrayList(numbers));

                i++;
                j--;

            }
        }
        // Rekurziv
        if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
    }

    public ArrayList<MyArrayList> getAllState() {
        return allState;
    }
}
