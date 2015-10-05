package utility;

import java.util.ArrayList;

/**
 * Created by Abraham on 2015. 10. 01..
 */
public class MyArrayList<E> extends ArrayList<E> {

    public MyArrayList<E> getSubArray(int startIndex, int endIndex) {
        MyArrayList<E> mySubArray = new MyArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
            mySubArray.add(this.get(i));
        }
        return mySubArray;
    }

    public void swap(int oneIndex, int otherIndex) {
        //kiszedem a két elemet
        E oneElement = this.get(oneIndex);
        E otherElement = this.get(otherIndex);

        //hozzáadom a másik element az elsõ elem helyére
        this.set(oneIndex, otherElement);
        this.set(otherIndex, oneElement);
    }

}
