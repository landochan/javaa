import java.io.*;
public class GameSaver {
	public static void main(String[] args){
		GameChar aladin = new GameChar("mage",100, new String[]{"sorcery","magic dust"});
		GameChar bruce = new GameChar("fighter",200,new String[]{"punch","kick"});
		GameChar miya = new GameChar("marksman", 50, new String[]{"fire bow","meteor"});

		try{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("mygame.ser"));
			oos.writeObject(aladin);
			oos.writeObject(bruce);
			oos.writeObject(miya);
			oos.close();
		}catch(IOException ex){System.out.print("caught1");}
	
		try{	ObjectInputStream ois = new ObjectInputStream(new FileInputStream("mygame.ser"));
			GameChar one = (GameChar) ois.readObject();
			GameChar two = (GameChar) ois.readObject();
			GameChar three = (GameChar) ois.readObject();
		

			System.out.print(one.getType());
			System.out.print(", ");
			System.out.print(one.getHealth());
			System.out.print(", ");
			System.out.println(one.getWeapons());

			System.out.print(two.getType());
			System.out.print(", ");
			System.out.print(two.getHealth());
			System.out.print(", ");
			System.out.println(two.getWeapons());

			System.out.print(three.getType());
			System.out.print(", ");
			System.out.print(three.getHealth());
			System.out.print(", ");
			System.out.println(three.getWeapons());
		}catch(Exception ex){System.out.print("caught3");}
	}
}
