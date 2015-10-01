package algorithm;

import utility.MyArrayList;

import java.util.ArrayList;


/**
 * Created by Abraham on 2015. 10. 01..
 */
public class QuickSort {
    int k;

    public QuickSort(int k) {
        this.k = k;
    }

    public void quickSort(MyArrayList<Integer> numbers) {
        if (!numbers.isEmpty() && k > 0) {
            int k = movingToRightPlace(numbers);
            quickSort(numbers.getSubArray(0, k));
            quickSort(numbers.getSubArray(k, numbers.size()));
        }
    }

    public int movingToRightPlace(MyArrayList<Integer> numbers) {
        int u = 0;
        int v = numbers.size()-1;
        int i = u + 1;
        int j = v;

        while (i <= j) {
            while (i <= v && numbers.get(i) <= numbers.get(u)) {
                i++;
            }

            while (u + 1 <= j && numbers.get(u) <= numbers.get(j)) {
                j--;
            }

            if (i < j) {
                numbers.swap(i, j);
                i++;
                j--;
            }
        }
        numbers.swap(u, i - 1);

        return i - 1;
    }
}
