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
        //kiszedem (t�rl�m), �s elmentem az els� elemet
        E element = this.get(oneIndex);
        this.remove(oneIndex);

        //hozz�adom a m�sik element az els� elem hely�re
        this.add(oneIndex, this.get(otherIndex));

        //kiszedem a m�sik elemet, majd a m�sik elem hely�re berakom az els� elemet
        this.remove(otherIndex);
        this.add(otherIndex, element);
    }

}
