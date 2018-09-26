import java.io.*;
public class GameChar implements Serializable {
	static final long serialVersionUID = 8736873688739L;
	String type;
	int health;
	String[] weapons ;

	public GameChar (String a, int b, String[] c){
		type = a;
		health = b;
		weapons = c;
	}

	public String getType (){
		return type;
	}

	public int getHealth (){
		return health;
	}
	
	public String getWeapons (){
		String b = new String(" ");
		String comma = new String(", ");
		for(int i=0;i<weapons.length;i++){
			b+= weapons[i] + comma;
		}
		return  b;
	}
}
		
