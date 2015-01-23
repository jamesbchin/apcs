import java.util.*;
import java.io.*;
import sun.audio.AudioStream;
import sun.audio.AudioPlayer;
public class Schedule {
    
    private ArrayList<ArrayList> sched;
    private ArrayList<ArrayList> events;

    /*
      for ArrayList sched:
      Outer ArrayList: hours in a day (0 to 23), however, the index is from 0 to 24, so 0000 in military time (midnight) is index 1
          type: ArrayList
      Inner ArrayList: days in a week (Sunday to Saturday). The index is from 0 to 14. The actual days are the even numbers, while the odd indices are there for formatting purposes.
          type: Object
	     Can contain Strings (which makes formatting easier) but can also contain ints (which makes everything else easier). Thus, typecasting is sometimes necessary.

    VERY IMPORTANT: REMEMBER THE WEIRD INDICES
    any day should be 2 * day
    any hour should be 1 + hour
    */

    public Schedule() {
	sched = new ArrayList<ArrayList>();
	for (int i = 0; i < 25; i++) {
	    ArrayList meow = new ArrayList();
	    for (int j = 0; j < 15; j++) {
		meow.add(0);
	    }
	    sched.add(i, meow);
	}
	events = new ArrayList<ArrayList>();
    }
    
    public String toString() {
	String s = "";
	for (int i = 0; i < 25; i++) {
	    for (int j = 0; j < 15; j++) {
		s+=sched.get(i).get(j) + " ";
	    }
	    s += "\n";
	}
	return s;
    }
    
    public void add(int hour, int day, Object activity) {
	sched.get(hour).add(day, activity);
    }
    
    /*
      More user-friendly add function
      startTime is a number from 0 - 23 (inclusive)
      endTime is a number from 0 - 23 (exclusive)
      day is a number from 0 - 6
      event is a string
         
    public void addEvent(int startTime, int endTime, int day, String event) {
	for (int i = startTime; i < endTime; i++) {
	    int t = i;
	    int x = 2;
	    if (t > 11) {
		t = t - 12;
		x++;
	    }
	    //add(t , x + ( day * 3), event);
	    sched.get(t+1).set(x + ( day * 3), event);
	}
    }

    add for ArrayLists of ArrayLists for events
    */
    
    public void addEvent(int day, int startTime, int endTime, String activity) {
	int x = 0;
	for (int a = 0; a < (endTime - startTime); a++) {
	    x = (int)sched.get(startTime + 1 + a).get(2 * day);
	    x++;
	    sched.get(startTime + 1 + a).set(2 * day, x);
	}
	ArrayList stuff = new ArrayList();
	if (events.isEmpty()) {
	    stuff.add(day);
	    stuff.add(startTime);
	    stuff.add(endTime);
	    stuff.add(activity);
	    events.add(stuff);
	}
	else {
	    for (int i = 0; i < events.size(); i++) {
		if (events.get(i).get(0) == day && events.get(i).get(1) == startTime && events.get(i).get(2) == endTime) {
		    events.get(i).add(activity);
		}
		else {
		    stuff.add(day);
		    stuff.add(startTime);
		    stuff.add(endTime);
		    stuff.add(activity);
		    events.add(stuff);
		}
	    }
	}   
    }

    public String showEvents(int day, int startTime, int endTime) {
	String s = "";
	if (events.isEmpty()) {
	    s += "You have no events for this time.";
	}
	else {
	    for (int i = 0; i < events.size(); i++) {
		if (events.get(i).get(0) == day && events.get(i).get(1) == startTime && events.get(i).get(2) == endTime) {
		    for (int j = 3; j < events.get(i).size(); j++) {
			s += events.get(i).get(j);
		    }
		}
		else {
		    s += "You have no events for this time.";
		}
	    }
	}
	return s;
    }
    
    public void base() {
	add(0,0,"  ");
	add(0,1," ");
	add(0,2,"S");
	add(0,3," ");
	add(0,4,"M");
	add(0,5," ");
	add(0,6,"T");
	add(0,7," ");
	add(0,8,"W");
	add(0,9," ");
	add(0,10,"T");
	add(0,11," ");
	add(0,12,"F");
	add(0,13," ");
	add(0,14,"S");
	add(0,15," ");
	/*
	  for (int i = 1; i <= 24; i++) {
	  sched.get(i).add(0, i - 1);
	  }
	*/
	for (int i = 0; i < 24; i++) {
	    if (i < 10) {
		String s = i + " ";
		add(i+1, 0, s);
	    }
	    else
		add(i+1, 0, i);
	}
	for (int j = 0; j < 7; j++){
	    for (int i = 0; i < 24; i++) {
		add(i+1, 2*j+1, "|");
	    }
	}
    }
    
    public void alarm(int hour, int minute, int second) throws Exception {
	long start = System.currentTimeMillis();
	long time = 3600*1000*hour + 60*1000*minute + 1000*second;
	while (System.currentTimeMillis() - start < time){}
	
	try {
	    InputStream in = new FileInputStream(new File("alarmclock.wav"));
	    AudioStream audioStream = new AudioStream(in);
	    AudioPlayer.player.start(audioStream);
	    System.out.println("\nTIME IS UP\n");
	}
	catch (Exception e) {
	    System.out.println("\nTIME IS UP\n");
	}
    }
    
    public String sleep(int hour, int minute) {
	if (hour < 12)
	    hour += 24;
	int hour1 = (hour - 9);
	if (hour1 > 24)
	    hour1 %= 24;
	int min2 = (minute + 30) % 60;
	int hour2 = (hour1 + 1 + (minute + 30)/60);
	if (hour2 > 24)
	    hour2 %= 24;
	int min3 = (min2 + 30) % 60;
	int hour3 = (hour2 + 1 + (min2 + 30)/60);
	if (hour3 > 24)
	    hour3 %= 24;
	int min4 = (min3 + 30) % 60;
	int hour4 = (hour3 + 1 + (min3 + 30)/60);
	if (hour4 > 24)
	    hour4 %= 24;
	
	String s = "Try to fall asleep at " + hour1 + ":";
	if (minute < 10)
	    s += "0";
	s += minute + " or " + hour2 + ":";
	if (min2 < 10)
	    s+= "0";
	s += min2 + " or " + hour3 + ":";
	if (min3 < 10)
	    s += "0";
	s += min3 + " or " + hour4 + ":";
	if (min4 < 10)
	    s += "0";
	s += min4;
	return s;
    }
    
    public static void main(String[] args) {
	Schedule rawr = new Schedule();
	/*rawr.base();
	rawr.addEvent(1,1,2,"poop");
	System.out.println(rawr.showEvents(1,1,2));
	System.out.println(rawr.showEvents(3,2,5));
	*/
	GettingCurrentDate time = new GettingCurrentDate();
	Scanner s = new Scanner(System.in);
	boolean loop = true;
	String option = "";
	Music m = new Music();
      
	System.out.println("");
	System.out.println("-------------------------");
	System.out.println("Welcome to Your Schedule!");
	System.out.println("-------------------------");
	System.out.println("Time and Date: " + time.date());
	
	while (loop == true) {
	    System.out.println("Please select an option:\n\n1: Alarm\n2: Bedtime Calculator\n3: Music Player");
	    option = s.next();
	    
	    if (option.equals("1") || option.toLowerCase().equals("alarm")) {
		System.out.print("Please enter an integer number of hours: ");
		int hour = s.nextInt();
		System.out.print("Please enter an integer number of minutes: ");
		int min = s.nextInt();
		System.out.print("Please enter an integer number of seconds: ");
		int sec = s.nextInt();
		try {
		    rawr.alarm(hour, min, sec);
		    try {
			Thread.sleep(5000);
		    }
		    catch (Exception e) {}
		}
		catch (Exception e) {
		    System.out.println("I'm sorry, but the alarm is not working. Please try again.");
		}
	    }

	    else if (option.equals("2") || option.toLowerCase().equals("bedtime calculator")) {
		System.out.println("\nSleep cycles usually last ~90 minutes. It is best to plan so that you wake up between sleep cycles, instead of in the middle of one, to get maximum alertness.\n");
		System.out.print("Please enter the hour you would like to get up (military time): ");
		int hour = s.nextInt();
		System.out.print("Please enter the minute you would like to get up: ");
		int min = s.nextInt();
		System.out.println(rawr.sleep(hour, min));
	    }

	    else if (option.equals("3") || option.toLowerCase().equals("music player")) {
		boolean check = true;
		while (check == true) {
		    System.out.println("What would you like to do? Please choose a number:\n1: Listen to music\n2: Add songs to your playlist\n3: Remove songs from your playlist\n4: Save your playlist\n5: Upload a playlist\n6: Exit music");
		    int choice = s.nextInt();
		    if (choice == 1) {
			System.out.println("Please choose a song (enter the number): ");
			System.out.println(m);
			int song = s.nextInt();
			m.playMusic(m.get(song));
		    }
		    else if (choice == 2) {
			System.out.println("Please enter a file name for your song, including the path directory. wav is the best file format. Other file formats may not work.\n");
			String file = s.next();
			m.addMusic(file);
		    }
		    else if (choice == 3) {
			System.out.println("Please choose the number of the song you would like to remove.");
			System.out.println(m);
			int remove = s.nextInt();
			m.removeMusic(remove);
		    }
		    else if (choice == 4) {
			System.out.println("Please enter the name of the text file that you want to save to: ");
			String save = s.next();
			m.saveMusic(save);
		    }
		    else if (choice == 5) {
			System.out.println("Please enter the name of the text file you want to upload: ");
			String upload = s.next();
			m.uploadMusic(upload);
		    }
		    else if (choice == 6) {
			check = false;
		    }
		    else {
			System.out.println("That is not a valid option. Please try again.");
		    }
		}
	    }
	    else {
		System.out.println("That is not a valid option. Please try again.");
	    }
	}
	    /*
	      System.out.println(rawr);
	      rawr.base();
	      
	      rawr.add(5, 6, "meow");
	      rawr.add(2, 4, "rawr");
	      
	      rawr.addEvent(10,14,3,"J");
	      System.out.println(rawr);
	    */
	    rawr.addEvent(5, 10, 13, "compsci class");
	    System.out.println(rawr);
    }
}
