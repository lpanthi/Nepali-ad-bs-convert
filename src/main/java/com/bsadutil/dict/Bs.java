package com.bsadutil.dict;
import com.bsadutil.core.Ymd;
import com.bsadutil.error.OutOfBoundError;

public class Bs implements Dictionary {

    private static int[][] data = {
        {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31, 366},
        {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31, 366},
        {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {30, 32, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31, 366},
        {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31, 366},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 32, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {30, 32, 31, 32, 31, 31, 29, 30, 29, 30, 29, 31, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 29, 31, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {31, 31, 31, 32, 31, 31, 29, 30, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 31, 366},
        {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 30, 29, 31, 366},
        {31, 31, 31, 32, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 29, 30, 29, 30, 30, 365},
        {31, 32, 31, 32, 31, 30, 30, 30, 29, 29, 30, 30, 365},
        {31, 31, 32, 32, 31, 30, 30, 30, 29, 30, 30, 30, 366},
        {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30, 365},
        {31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30, 365},
        {31, 31, 32, 31, 31, 30, 30, 30, 29, 30, 30, 30, 365},
        {31, 32, 31, 32, 30, 31, 30, 30, 29, 30, 30, 30, 366},
        {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30, 365},
        {31, 31, 32, 31, 31, 31, 30, 30, 29, 30, 30, 30, 366},
        {30, 31, 32, 32, 30, 31, 30, 30, 29, 30, 30, 30, 365},
        {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30, 365},
        {30, 32, 31, 32, 31, 30, 30, 30, 29, 30, 30, 30, 365}
    };

    private static Ymd min = new Ymd(2000, 9, 17);
    private static Ymd max = new Ymd(2090, 12, 30);

    public int get(int y) {
        return get(y, 13);
    }

    public int get(int y, int m) {
        assertMonth(m);
        assertYear(y);
        return Bs.data[y - min.year()][m - 1];
    }

    public boolean isLeapYear(int y) {
        boolean isLeap = (get(y) == 366);
        return isLeap;
    }

    public Ymd max() {
        return Bs.max;
    }

    public Ymd min() {
        return Bs.min;
    }

    private static void assertMonth(int m) {
        if (m > 12 + 1 || m <= 0)
            throw new OutOfBoundError();
    }

    private static void assertYear(int y) {
        if (y > Bs.max.year() || y < Bs.min.year())
            throw new OutOfBoundError();
    }

}
