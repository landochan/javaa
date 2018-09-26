import java.util.*;

public class testHashMap {
	public static void main (String[] args) {
		HashMap<String, Integer> scores = new HashMap<String, Integer>();
		
		scores.put("Ronaldinho", 500);
		scores.put("Messi", 777);
		scores.put("Ronaldo", 765);
		scores.put("Lando", 1000);
	
		System.out.println(scores);
	}
}
