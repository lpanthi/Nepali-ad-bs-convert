package com.bsadutil.lang;
import com.bsadutil.error.OutOfBoundError;

public class Translator {

    // Converts the index into corresponding month name
    public static String mahina(int i, boolean nepali) {
        if (i <= 0 || i > 12)
            throw new OutOfBoundError();
        String[] e = {
        		"Baisakh", "Jesth", "Ashadh", "Shrawan", "Bhadra", "Ashwin", "Kartik", "Mangsir", "Paush", "Magh", "Falgun", "Chaitra"
        };
        String[] n = {
            "बैशाख", "जेष्ठ", "आषाढ", "श्रावन", "भाद्र", "असोज",
            "कार्तिक", "मंसिर", "पौष", "माघ", "फागुन", "चैत्र"
        };
        return nepali ? n[i - 1] : e[i - 1];
    }

    // Converts the index into correspoinding name
    public static String bar(int i, boolean nepali) {
        if (i <= 0 || i > 7)
            throw new OutOfBoundError();

        String[] e = {
            "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"
        };
        String[] n = {
            "आइतबार", "सोमबार", "मंगलबार", "बुधबार", "बिहिबार", "सुक्रबार", "सनिबार"
        };

        return nepali ? n[i - 1] : e[i - 1];
    }

    // Converts the english number into nepali representation
    public static String anka(int x, boolean nepali, int digits) {
        String[] e = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"
        };

        String[] n = {
            "०", "१", "२", "३", "४", "५", "६", "७", "८", "९"
        };

        String[] fmt = nepali ? n : e;

        // Return if x is 0
        if (x == 0)
            return fmt[0];

        String word = "";
        for (int i = x; i > 0; i /= 10)
            word = fmt[i % 10] + word;

        // Padding output with extra zeros
        int fill = digits - ((int)Math.log10(x) + 1);
        for (int i = 0; i < fill; i++)
            word = fmt[0] + word;
        return word;
    }

}
