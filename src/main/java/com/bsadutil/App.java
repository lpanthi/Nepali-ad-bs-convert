package com.bsadutil;
import com.bsadutil.core.Date;
import com.bsadutil.dict.Ad;
import com.bsadutil.dict.Bs;
import com.bsadutil.lang.Translator;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        try {
            // Get Ad and Bs dictionaries for calendar data
            Ad ad = new Ad();
            Bs bs = new Bs();

            // Get some arbitrary date
            Date<Ad> a = new Date<Ad>(2021, 7, 12, new Ad());
            // Convert AD to BS
            Date<Bs> x = a.convertTo(bs);
            // Convert BS to AD
            // Date<Ad> y = x.convertTo(ad);

            // Print header
            System.out.println(Translator.anka(x.year(), true, 4) + "\t"
                                + Translator.mahina(x.month(), true) + "\t"
                                + Translator.anka(x.day(), true, 2) + "\t"
                                + Translator.bar(x.week(), true));

            Date<Ad> firstDayOfNepaliMonth = x.firstDayOfMonthIn(ad);

            // Fill gap for calendar
            int pos;
            for (pos = 1; pos <= firstDayOfNepaliMonth.week(); pos++)
                System.out.print("  -  \t");
            // Fill dates for calendar
            for (int nepaliDay = 1, englishDay = firstDayOfNepaliMonth.day();
                    nepaliDay <= x.daysInMonth();
                    nepaliDay++, englishDay++, pos++) {
                if (englishDay > firstDayOfNepaliMonth.daysInMonth()) {
                    englishDay = 1;
                }
                System.out.print(englishDay + " " + Translator.anka(nepaliDay, true, 2) + "\t");
                // break at 7th position
                if (pos % 7 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
            
            
            // ****************************
            
            Date<Ad> englishDate;
            Date<Bs> nepaliDate;
            Date<Bs> anotherNepaliDate;
            // Date conversion
            englishDate = new Date<Ad>("2017-07-5", ad);
            anotherNepaliDate = new Date<Bs>(2070, 10, 11, bs);
            
            System.out.println(nepaliDate = englishDate.convertTo(bs));   // 2074-03-31
            nepaliDate.addDays(120);                  // 2074-07-26
            nepaliDate.addMonths(4);                  // 2074-07-30
            nepaliDate.addYears(2);                   // 2076-03-31
            nepaliDate.subtractDays(111);             // 2073-12-13
            nepaliDate.difference(anotherNepaliDate); // 1267
            nepaliDate.week();                        // 7
            nepaliDate.daysInMonth();                 // 31
            nepaliDate.daysInYear();                  // 365
            

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
