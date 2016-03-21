package sg.com.hiwire.customlibrary;

import java.util.Random;

public class RandomInt {
    private static int aStart = 100000000;
    private static int aEnd = 999999999;

    private RandomInt(){}

    public static int get() {
        Random aRandom = new Random();
        //get the range, casting to long to avoid overflow problems
        long range = (long) aEnd - (long) aStart + 1;
        // compute a fraction of the range, 0 <= frac < range
        long fraction = (long) (range * aRandom.nextDouble());
        return ((int) (fraction + aStart));
    }
}
