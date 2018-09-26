import java.util.*;
import java.io.*;

public class usingHashSet {
	ArrayList<Song> songlist = new ArrayList<Song>();
	TreeSet<Song> songlist2 = new TreeSet<Song>();
	HashSet<Song> songlist3 = new HashSet<Song>();
	public static void main (String[] args) {
		new usingHashSet().go();
	}
	public void go() {
		getSong();
		songlist3.addAll(songlist);
		System.out.println("by ARRAYLIST :\n" + songlist);
		System.out.println("by HASHSET :\n" +songlist3);
		System.out.println("by TREESET :\n" +songlist2);
		Collections.sort(songlist);
		System.out.println("sorted ARRAYLIST:\n" +songlist);
	
	}
	public void getSong() {
		String message = null;
		try {
			BufferedReader br = new BufferedReader (new FileReader(new File ("SongListMore.txt")));
			while((message = br.readLine())!= null) {
				makeSong(message);
			}
		} catch(Exception ex) {ex.printStackTrace(); }
	}
	public void makeSong(String message) {
		String[] tokens  = new String[4];
		tokens = message.split("/");
		int a = Integer.parseInt(tokens[2]);
		int b = Integer.parseInt(tokens[3]);
		Integer a1 = new Integer(a);
		Integer a2 = new Integer(b);
		Song newsong = new Song(tokens[0], tokens[1], a1, a2);
		songlist.add(newsong);
		songlist2.add(newsong);
	}
}
class Song implements Comparable<Song>{
	String title;
	String artist;
	Integer num1;
	Integer num2;
	public int compareTo(Song a){
		return  title.compareTo(a.getTitle());
	}	
	public int hashCode() {
		return artist.hashCode();
	}
	public boolean equals(Object asong) {
		Song a = (Song) asong;
		return getTitle().equals(a.getTitle());
	}
	public Song(String a, String b, Integer c, Integer d) {
		title =a;
		artist = b;
		num1 =c;
		num2 =d;
	}
	public String getTitle() {
		return title;
	}
	public  String getArtist() {
		return artist;
	}
	public String toString () {
		return title;
	}
}
	
		
		
	
