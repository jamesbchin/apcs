import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GettingCurrentDate {

  String[] time = new String[6];
  String report;

  public GettingCurrentDate() {
    DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
    Date today = Calendar.getInstance().getTime();
    report = df.format(today);
    
    String day[] = report.split("/|:| ");
    for(int i = 0; i < 6; i++) {
      time[i] = day[i];
    }
  }
  
  public String toString() {
    String s = "";
    for (int i = 0; i < 6; i++) {
      s+= time[i] + " ";
    }
    return s;
  }
  public String date() {
    return report;
  }
  
/*
  public static void main(String[] args) {
    GettingCurrentDate g = new GettingCurrentDate();
    System.out.println(g);
  }
*/
}    


