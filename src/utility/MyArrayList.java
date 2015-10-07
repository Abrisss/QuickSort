package utility;

import java.util.ArrayList;

/**
 * Created by Abraham on 2015. 10. 01..
 */
public class MyArrayList extends ArrayList<MyNumber> {

    public MyArrayList(){
        super();
    }
    public MyArrayList(MyArrayList myArrayList){
        for(MyNumber myNumber: myArrayList){
            this.add(new MyNumber(myNumber.getValue(),myNumber.isPivot(), myNumber.isI(), myNumber.isJ()));
        }
    }

    public void swap(int oneIndex, int otherIndex) {
        //kiszedem a két elemet
        MyNumber oneElement = this.get(oneIndex);
        MyNumber otherElement = this.get(otherIndex);

        //hozzáadom a másik element az elsõ elem helyére
        this.set(oneIndex, otherElement);
        this.set(otherIndex, oneElement);
    }

    public void setPivot(int index) {
        for (MyNumber myNumber : this) {
            myNumber.setIsPivot(false);
        }
        this.get(index).setIsPivot(true);
    }

    public void setI(int index) {
        for (MyNumber myNumber : this) {
            myNumber.setIsI(false);
        }
        this.get(index).setIsI(true);
    }

    public void setJ(int index) {
        for (MyNumber myNumber : this) {
            myNumber.setIsJ(false);
        }
        this.get(index).setIsJ(true);
    }

}
