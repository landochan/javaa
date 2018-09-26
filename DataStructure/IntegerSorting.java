import java.util.*;
import java.io.*;

public class IntegerSorting {
	ArrayList<player> playerlist = new ArrayList<player>();
	public static void main (String[] args) {
		new collectionsorting().go();
	}
	public void go() {
		getplayerlist();
		showplayerlist();
	}
	class GetName implements Comparator<player> {
		public int compare (player p1, player p2){
			return -(p1.getScore().compareTo(p2.getScore()));
		}
	}
	public void getplayerlist() {
		player p1 = new player("lando", "baka", 100);
		player p2 = new player("baka", "ando", 50);
		player p3 = new player ("messi", "baka", 500);
		player p4 = new player ("ronaldinho" , "baka",300);
		playerlist.add(p1);
		playerlist.add(p2);
		playerlist.add(p3);
		playerlist.add(p4);
	}
	
	public void showplayerlist() {
		GetName getname = new GetName();
		Collections.sort(playerlist, getname);
		System.out.println(playerlist);	
	}
}
	

class player {
	String name;
	String number;
	Integer score;
	public player (String a, String b, Integer c) {
		name =a;
		number = b;
		score = c;
	}
	public String getName () {
		return name;
	}
	public String getNumber () {
		return number;
	}
	public Integer getScore() {
		return score;
	}
	public String toString() {
		return name;
	}
}
			
