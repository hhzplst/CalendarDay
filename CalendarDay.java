package Lab1AssignmentA;

public class CalendarDay implements Comparable<CalendarDay> {
  private int month, day, year;

  public CalendarDay(String data) {
    String[] temp = data.split("/");
    month = Integer.parseInt(temp[0]);
    day = Integer.parseInt(temp[1]);
    year = Integer.parseInt(temp[2]);
  }

  public CalendarDay(int m, int d, int y) {
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

  public void setMonth(int m) {
    month = m;
  }

  public void setDay(int d) {
    day = d;
  }

  public void setYear(int y) {
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
    return result;
  }

  public int compareTo(CalendarDay cd) {
    return 1;
  }
}