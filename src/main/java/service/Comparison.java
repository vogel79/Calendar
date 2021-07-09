package service;

import domain.Calendar;

public class Comparison {

    public static void sortBigger(Calendar[] dates) {
        for (int i = dates.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (dates[j] != null && dates[j + 1] != null) {
                    if (dates[j].after(dates[j + 1])) {
                        Calendar tmp = dates[j];
                        dates[j] = dates[j + 1];
                        dates[j + 1] = tmp;
                    }
                }
            }
        }
    }

    public static void sortSmaller(Calendar[] dates) {
        for (int i = dates.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (dates[j] != null && dates[j + 1] != null) {
                    if (dates[j].before(dates[j + 1])) {
                        Calendar tmp = dates[j];
                        dates[j] = dates[j + 1];
                        dates[j + 1] = tmp;
                    }
                }
            }
        }
    }
}
