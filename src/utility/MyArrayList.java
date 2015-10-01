package utility;

import java.util.ArrayList;

/**
 * Created by Abraham on 2015. 10. 01..
 */
public class MyArrayList<E> extends ArrayList<E> {

    public MyArrayList<E> getSubArray(int startIndex, int endIndex) {
        MyArrayList<E> mySubArray = new MyArrayList<>();
        for (int i = startIndex; i < endIndex; i++) {
//            System.out.println(this.get(i));
            mySubArray.add(this.get(i));
        }
        return mySubArray;
    }

    public void swap(int oneIndex, int otherIndex) {
        //kiszedem (törlöm), és elmentem az elsõ elemet
        E element = this.get(oneIndex);
        this.remove(oneIndex);

        //hozzáadom a másik element az elsõ elem helyére
        this.add(oneIndex, this.get(otherIndex));

        //kiszedem a másik elemet, majd a másik elem helyére berakom az elsõ elemet
        this.remove(otherIndex);
        this.add(otherIndex, element);
    }

}
