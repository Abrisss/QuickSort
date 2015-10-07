package utility;

/**
 * Created by Abraham on 2015. 10. 07..
 */
public class MyNumber  {
    private int value;
    private boolean isPivot;
    private boolean isI;
    private boolean isJ;

    public MyNumber(int value) {
        this.value = value;
        isPivot = false;
        isI = false;
        isJ = false;
    }

    public MyNumber(int value, boolean isPivot, boolean isI, boolean isJ) {
        this.value = value;
        this.isPivot = isPivot;
        this.isI = isI;
        this.isJ = isJ;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isPivot() {
        return isPivot;
    }

    public void setIsPivot(boolean isPivot) {
        this.isPivot = isPivot;
    }

    public boolean isI() {
        return isI;
    }

    public void setIsI(boolean isI) {
        this.isI = isI;
    }

    public boolean isJ() {
        return isJ;
    }

    public void setIsJ(boolean isJ) {
        this.isJ = isJ;
    }
}
