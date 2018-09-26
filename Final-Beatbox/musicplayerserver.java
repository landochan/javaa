import java.io.*;
import java.net.*;
import java.util.*;

public class musicplayerserver {
	ArrayList<ObjectOutputStream> objectoutputlist;
	public static void main (String[] args) {
		new musicplayerserver().go();
	}

	public void go() {
		objectoutputlist = new ArrayList<ObjectOutputStream>();
		int k = 1;
		try { 
			ServerSocket serversocket = new ServerSocket(4999);
			while(true) {			
				Socket socket = serversocket.accept();
				System.out.println(k + " connection made \n");
				k++;
				ObjectOutputStream oos = new ObjectOutputStream (socket.getOutputStream());
				objectoutputlist.add(oos);
				Thread t = new Thread (new runnable(socket));
				t.start();
				System.out.println("thread start");
			}
		}catch (Exception ex ){ ex.printStackTrace(); }
	}

	public class runnable implements Runnable {
		Socket socket;
		ObjectInputStream ois;
		public runnable (Socket s) {
			try {
				socket = s;
				ois = new ObjectInputStream (socket.getInputStream());
			} catch(Exception ex) {ex.printStackTrace(); }
		}
		public void run() {
			try{
				String message = null;
				Object object1 = null;
				Object object2 = null;
				while ((object1 = ois.readObject()) != null) {
					message = (String) object1;
					System.out.println (message);
					object2 = ois.readObject();
					telleveryone (object1, object2);
	
				}
			} catch (Exception ex) {ex.printStackTrace(); }
		}
	}
		
	public void telleveryone (Object object3, Object object4) {
		Iterator iterator = objectoutputlist.iterator();
		while(iterator.hasNext()){
			try{
				ObjectOutputStream ous = (ObjectOutputStream) iterator.next();
				ous.writeObject(object3);
				ous.writeObject(object4);
			} catch (Exception ex ) { ex.printStackTrace(); }
		}
	}
}
		
			
