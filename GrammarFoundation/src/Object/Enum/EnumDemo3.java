package Object.Enum;

import java.security.PublicKey;

/*
@author 黄佳豪
@create 2019-07-21-16:42
*/
public class EnumDemo3 {
    public static void main(String[] args) {
        String s = args[0];
        Week week = Week.valueOf(s);
        printWeek(week);
    }

    public static void printWeek(Week week) {
        switch (week) {
            case MONDAY:
                System.out.println("yi");
                break;
            case TUESDAY:
                System.out.println("2");
            case WENDSDAY:
                System.out.println("3");
        }
    }
}

enum Week {
    MONDAY(1), TUESDAY(2), WENDSDAY(3);
    private int value;

    Week(int value) {
        this.value = value;
    }
}