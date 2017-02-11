import java.util.Arrays;

public class CalendarDay implements Comparable<CalendarDay> {
  private int month, day, year;
  private static final int[] MONTH_31 = {1,3,5,7,8,10,12};
  private static final int[] MONTH_30 = {4,6,9,11};

  public CalendarDay(String data) throws DayException, MonthException, YearException {
    String[] temp = data.split("/");
    int m = Integer.parseInt(temp[0]);
    int d = Integer.parseInt(temp[1]);
    int y = Integer.parseInt(temp[2]);

    checkValidity(m,d,y);
    month = m;
    day = d;
    year = y;
  }

  public CalendarDay(int m, int d, int y) throws DayException, MonthException, YearException {
    checkValidity(m, d, y);
    month = m;
    day = d;
    year = y;
  }

  public CalendarDay(CalendarDay cd) {
    month = cd.month;
    day = cd.day;
    year = cd.year;
  }

  public int getMonth() {
    return month;
  }

  public int getDay() {
    return day;
  }

  public int getYear() {
    return year;
  }

  public void setMonth(int m) throws DayException, MonthException, YearException {
    checkValidity(m, day, year);
    month = m;
  }

  public void setDay(int d) throws DayException, MonthException, YearException {
    checkValidity(month, d, year);
    day = d;
  }

  public void setYear(int y) throws DayException, MonthException, YearException {
    checkValidity(month, day, y);
    year = y;
  }

  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof CalendarDay)) return false;

    CalendarDay cd = (CalendarDay) o;
    return cd.month == month && cd.day == day && cd.year == year;
  }

  public int hashCode() {
    int result = 17;
    result = 31 * result + month;
    result = 31 * result + day;
    result = 31 * result + year;
    return result;
  }

  public String toString() {
    String result = "";
    result = month + "/" + day + "/" + year;
    result += " (mm/dd/yyyy)";
    return result;
  }

  public int compareTo(CalendarDay cd) {
    if (this.equals(cd)) return 0;
    if (year > cd.year) 
      return 1;
    else if (year < cd.year)
      return -1;
    else {
      if (month > cd.month)
        return 1;
      else if (month < cd.month)
        return -1;
      else {
        if (day > cd.day)
          return 1;
        else 
          return -1;
      }
    }
  }

  private static boolean isLeapYear(int year) {
    if (year % 4 == 0) {
      if (year % 100 != 0) return true;
      if (year % 400 == 0) return true;        
    }
    return false;
  }

  private static void checkValidity(int m, int d, int y) throws DayException, MonthException, YearException {
    if (y < 1000 || y > 3000) throw new YearException("Year has to be integers between 1000 and 3000");
    if (m < 1 || m > 12) throw new MonthException("Month has to be integers between 1 and 12");
    if (d < 1)
      throw new DayException("Day should not be less than 1");
    else {
      if (Arrays.binarySearch(MONTH_31, m) != -1)
        if (d > 31) throw new DayException("Current month has at most 31 days"); 
      if (Arrays.binarySearch(MONTH_30, m) != -1)
        if (d > 30) throw new DayException("Current month has at most 30 days");
      if (m == 2) {
        if (!isLeapYear(y))
          if (d > 28) throw new DayException("Current year has at most 28 days in February");
        if (d > 29) throw new DayException("Current year has at most 29 days in February");
      }
    }
  }
}