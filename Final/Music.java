import java.util.*;
import java.io.*;
import sun.audio.AudioStream;
import sun.audio.AudioPlayer;

public class Music {
    
    private ArrayList<String> music;

    public Music() {
	music = new ArrayList<String>();
	music.add("Bach_little_fugue_in_g_minor.wav");
    }
    
    public String toString() {
	String s = "";
	for (int i = 0; i < music.size(); i++) {
	    s += i + 1 + ": " + music.get(i) + "\n";
	}
	return s;
    }

    public String onlySongs() {
	String s = "";
	for (int i = 0; i < music.size(); i++) {
	    s += music.get(i) + "\n";
	}
	return s;
    }

    public void addMusic(String s) {
	music.add(s);
    }

    public void removeMusic(int n) {
	music.remove(n-1);
    }

    public void saveMusic(String fileName) {
	BufferedWriter out = null;
	try {
	    out = new BufferedWriter(new FileWriter(fileName));
	    out.write(onlySongs());
	    System.out.println("Music saved.");
	}
	catch (Exception e) {
	    System.out.println("Music cannot be saved.");
	}
	finally {
	    try {
		if (out != null)
		    out.close();
	    }
	    catch (Exception e) {}
	}
    }

    public void uploadMusic(String fileName) {
	try {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();
	    while (line != null) {
		sb.append(line);
		sb.append("\n");
		line = br.readLine();
	    }
	    String text = sb.toString();
	    String[] songs = text.split("\n");
	    for (int i = 0; i < songs.length; i++) {
		music.set(i, songs[i]);
	    }
	    System.out.println("Music successfully uploaded.");
	}
	catch (Exception e) {
	    System.out.println("Music could not be uploaded.");
	}
    }    

    public void playMusic(String s) {
	Scanner scan = new Scanner(System.in);
	try {
	    InputStream in = new FileInputStream(new File(s));
	    AudioStream audioStream = new AudioStream(in);
	    AudioPlayer.player.start(audioStream);
	    System.out.println("\nCurrently playing " + s);
	}
	catch (Exception e) {
	    System.out.println("\nFile is missing.");
	}
    }
    
    public String get(int n) {
	return music.get(n-1);
    }

    public static void main(String[] args) {
	Music m = new Music();
	m.addMusic("Debussy_claire_de_lune.wav");
	/*System.out.print(m);
	m.playMusic(m.get(2));
	m.saveMusic("music.txt");
	m.uploadMusic("music.txt");
	System.out.println(m);
	*/
      
    }
}