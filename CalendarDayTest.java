import java.util.Arrays;
import java.util.Scanner;

public class CalendarDayTest {
  public static void main(String[] args) {
    int count = 0;
    CalendarDay[] cds = new CalendarDay[5];

    while(count <= 4) {
      Scanner s = new Scanner(System.in);
      System.out.print("Please input a calendar day in mm/dd/yyyy format: ");
      String input = s.next();
      try {
        CalendarDay calTest = new CalendarDay(input);
        cds[count++] = calTest;
      } catch (YearException ye) {
        System.out.println(ye.getMessage());
      } catch (MonthException me) {
        System.out.println(me.getMessage());
      } catch (DayException de) {
        System.out.println(de.getMessage());
      }
    }

    Arrays.sort(cds);

    System.out.println("The calendar days entered in ascending order: ");
    for (CalendarDay cd : cds)
      System.out.println(cd);
  }
}

/*****************************OUTPUT*****************************

➜  AssignmentA git:(master) ✗ javac *.java        
➜  AssignmentA git:(master) ✗ java CalendarDayTest 
Please input a calendar day in mm/dd/yyyy format: 02/30/1990
Current year has at most 28 days in February
Please input a calendar day in mm/dd/yyyy format: 02/29/2012
Please input a calendar day in mm/dd/yyyy format: 06/31/1990
Current month has at most 30 days
Please input a calendar day in mm/dd/yyyy format: 01/01/2012
Please input a calendar day in mm/dd/yyyy format: 03/15/1991
Please input a calendar day in mm/dd/yyyy format: 07/01/1990
Please input a calendar day in mm/dd/yyyy format: 07/32/1990
Current month has at most 31 days
Please input a calendar day in mm/dd/yyyy format: 07/30/1990
The calendar days entered in ascending order: 
7/1/1990 (mm/dd/yyyy)
7/30/1990 (mm/dd/yyyy)
3/15/1991 (mm/dd/yyyy)
1/1/2012 (mm/dd/yyyy)
2/29/2012 (mm/dd/yyyy)

****************************END OUTPUT***************************