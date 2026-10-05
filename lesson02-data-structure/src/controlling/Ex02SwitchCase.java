package controlling;

public class Ex02SwitchCase {

    public static void main(String[] args) {

        int month1 = 2;
        int year1 = 2024;

        int days1 = getDaysInMonth(month1, year1);
        System.out.println("[Classic switch] --> Tháng " + month1 + " năm " + year1 + " có " + days1 + " ngày");

        int month2 = 12;
        int year2 = 2028;

        int days2 = getDaysInMonthWithLambda(month2, year2);
        System.out.println("[Switch lambda] --> Tháng " + month2 + " năm " + year2 + " có " + days2 + " ngày");
    }

    // ==============================
    // Cách 1: switch-case truyền thống
    // ==============================
    public static int getDaysInMonth(int month, int year) {

        int days;

        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12:
                days = 31;
                break;

            case 4, 6, 9, 11:
                days = 30;
                break;

            case 2:
                days = isLeapYear(year) ? 29 : 28;
                break;

            default:
                days = -1;
        }

        return days;
    }

    // ==============================
    // Cách 2: switch expression + lambda (->)
    // Java 14+
    // ==============================
    public static int getDaysInMonthWithLambda(int month, int year) {

        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> isLeapYear(year) ? 29 : 28;
            default -> -1;
        };
    }

    // ==============================
    // Kiểm tra năm nhuận
    // ==============================
    public static boolean isLeapYear(int year) {

        return (year % 400 == 0)
                || (year % 4 == 0 && year % 100 != 0);
    }
}
