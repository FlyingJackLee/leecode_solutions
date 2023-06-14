public class NumberOfDays1118 {
    public int numberOfDays(int year, int month) {
        int[] daysOfMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return month == 2 ? (isLeapYear(year) ? 29 : 28) : daysOfMonth[month - 1];
    }

    private boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) ||(year % 400 == 0);
    }
}
