import java.util.ArrayList;
import java.io.*;

public class DotComBust {

	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> DotComList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;
	
	private void setUpGame () {
		DotCom one = new DotCom();
		one.setName("Pets.comm");
		DotCom two = new DotCom();
		two.setName("Lando");
		DotCom three = new DotCom();
		three.setName("CHan");
		DotComList.add(one);
		DotComList.add(two);
		DotComList.add(three);

		System.out.println("Your goal is to sink three dotcoms.");
		System.out.println("pets.com, lando, chan");
		System.out.println("try to sink them all in the fewer number of guesses from a0 to g6");

		for(DotCom testtt : DotComList){
			ArrayList<String> newLocation = helper.placeDotCom(3);
			testtt.setLocationCells(newLocation);
		}
		
	}


	private void startPlaying() throws IOException {
		while(!DotComList.isEmpty()) {
			String userguess = helper.getuserinput("Enter a guess ");
		checkuserguess(userguess);}
		finishgame();
	}


	private void checkuserguess (String userguesss) {
		numOfGuesses++;
		String resultt = "miss";

		for (DotCom test1 : DotComList) {
			resultt = test1.checkYourself(userguesss);
			if (resultt.equals("hit")){
				break;
			}
			if (resultt.equals("kill")){
				DotComList.remove(test1);
				break;}
		}
		if (resultt.equals("miss")){
			System.out.println("miss");}
	}
	

	private void finishgame() {
		System.out.println("All Dot Coms are dead! Your stock is now worthless.");
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println("You got out before your options sank.");
		}
		else {
			System.out.println("Took you long enough. " + numOfGuesses + " guesses.");
			System.out.println("Fish are dancing with your options.");
		}
	}

		
	public static void main (String[] args) throws IOException{
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}
}
