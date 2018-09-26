import java.io.*;
import java.net.*;
import javax.sound.midi.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;

public class finalmusicplayer {
	String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga","Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo", "Open Hi Conga"};
	int[] instruments = {35, 42,46,38,49,39,50,60,70,72,64,56,58,47,67,63};
	ArrayList<JCheckBox> checkboxlist = new ArrayList<JCheckBox>();
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JTextField chatinput;
	HashMap <String, boolean[]> hashmap;
	JList list;
	Vector<String> listvector;
	public static void main(String[] args){ 
		new finalmusicplayer().go();
	}

	public void go() {
		setupgui();
	}
	
	public void setupgui() {
		JFrame frame = new JFrame("LANDO MUSIC APP");
		JPanel eastpanel = new JPanel();
		JPanel functionpanel = new JPanel();
		JPanel chatpanel = new JPanel();
		JPanel chatdisplaypanel = new JPanel();
		JPanel chatinputpanel = new JPanel();
		JButton startbutton = new JButton("Start");
		JButton stopbutton = new JButton("Stop");
		JButton tempoupbutton = new JButton ("Tempo Up");
		JButton tempodownbutton = new JButton ("Tempo Down");
		JButton savebutton = new JButton("Save");
		JButton restorebutton = new JButton("Restore");
		JButton sendbutton = new JButton("Send");
		JButton resetbutton = new JButton("Reset");
		chatinput = new JTextField(20);
		list = new JList();
		JScrollPane scroller = new JScrollPane(list);
		GridLayout grid = new GridLayout(16,20);
		GridLayout instrumentgrid = new GridLayout(16,1);
		JPanel centerpanel = new JPanel(grid);
		JPanel westpanel = new JPanel(instrumentgrid);
		hashmap = new HashMap<String, boolean[]>();
		listvector = new Vector<String>();
	
		setupnetworking();	
		
		try{	
			sequencer = MidiSystem.getSequencer();
			sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.open();

		}catch(Exception ex) {ex.printStackTrace(); 
		}

		list.addListSelectionListener(new listlistener());
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setListData(listvector);
		startbutton.addActionListener(new startlistener());
		stopbutton.addActionListener(new stoplistener());
		tempoupbutton.addActionListener(new tempouplistener());
		tempodownbutton.addActionListener(new tempodownlistener());
		savebutton.addActionListener(new savelistener());
		restorebutton.addActionListener(new restorelistener());
		sendbutton.addActionListener(new sendlistener());
		resetbutton.addActionListener(new resetlistener());

		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(screensize.width, screensize.height);
		frame.getContentPane().add(BorderLayout.EAST, eastpanel);
		frame.getContentPane().add(BorderLayout.CENTER, centerpanel);
		frame.getContentPane().add(BorderLayout.WEST, westpanel);
		
		eastpanel.setLayout(new BoxLayout (eastpanel, BoxLayout.Y_AXIS));
		eastpanel.add(functionpanel);
		eastpanel.add(chatpanel);

		functionpanel.setLayout(new BoxLayout(functionpanel, BoxLayout.Y_AXIS));
		functionpanel.add(startbutton);
		functionpanel.add(stopbutton);
		functionpanel.add(tempoupbutton);
		functionpanel.add(tempodownbutton);
		functionpanel.add(savebutton);
		functionpanel.add(restorebutton);
		functionpanel.add(resetbutton);

		chatpanel.setLayout(new BoxLayout (chatpanel, BoxLayout.Y_AXIS));
		chatpanel.add(chatdisplaypanel);
		chatpanel.add(chatinputpanel);

		chatdisplaypanel.add(scroller);
		
		chatinputpanel.add(chatinput);
		chatinputpanel.add(sendbutton);
		
		for(int i=0; i<16; i++) {
			JLabel label = new JLabel(instrumentNames[i]);
			westpanel.add(label);
		}

		for(int i= 0;i<16;i++){
			for (int j=0; j<20; j++){
				JCheckBox checkbox = new JCheckBox();
				checkbox.setSelected(false);
				centerpanel.add(checkbox);
				checkboxlist.add(checkbox);
			}
		}
		
		frame.setVisible(true);
	}
	
	Socket socket;
	ObjectOutputStream ous;
	ObjectInputStream ois;
	public class listlistener implements ListSelectionListener {
		public void valueChanged (ListSelectionEvent le){
			if ((le.getValueIsAdjusting()) == false) {
				System.out.println("the value is not adjusting");
				String key = (String) list.getSelectedValue();
				boolean[] booleanlist2 = new boolean[320];
				if (key!= null){
					booleanlist2 = (boolean[]) hashmap.get(key);
					selectedcheckbox(booleanlist2);
				}
			}
		}
	}
					
	public void selectedcheckbox (boolean[] booleanlist3){
		for(int i=0; i<320; i++) {
			if (booleanlist3[i]){
				checkboxlist.get(i).setSelected(true);
			}
			else {
				checkboxlist.get(i).setSelected(false);
			}
		}
	}
			
	public void setupnetworking() {
		try {	
			socket = new Socket("127.0.9.1", 4999);
			ous = new ObjectOutputStream (socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			Thread t = new Thread (new runnable());
			t.start();
		} catch (Exception ex) {ex.printStackTrace();}
	}

	public class runnable implements Runnable {
		public void run() {
			String message = null;
			Object obj =null;
			boolean[] booleanlist = new boolean[320];
			try{
				while((obj = ois.readObject())!= null){
					message = (String) obj;
					booleanlist = (boolean[]) ois.readObject();
					listvector.add(message);
					hashmap.put(message, booleanlist);
					list.setListData(listvector);
				}	
			} catch (Exception ex) {ex.printStackTrace(); }
		}
	}
	public MidiEvent makeevent(int comd, int chan, int note, int volume, int time){
		MidiEvent event = null;
		try {
			ShortMessage message = new ShortMessage();
			message.setMessage(comd, chan, note, volume);
			event = new MidiEvent(message, time);
		} catch(Exception ex) { ex.printStackTrace(); }
		return event;
	}
	
	public class startlistener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			sequencer.stop();
			sequence.deleteTrack(track);
			track = sequence.createTrack();
			int k =0;
			for(int i= 0;i<16;i++){
				for (int j=0; j<20; j++){
					JCheckBox checkbox = new JCheckBox();
					checkbox = checkboxlist.get(k);
					k++;
					if (checkbox.isSelected()){
						track.add(makeevent(192,1,i,0,j));
						track.add(makeevent(144,1,40,100,j));
						track.add(makeevent(128,1,40,0,j+1));
					}
				}
			}
			try {
				sequencer.setSequence(sequence);
			} catch (Exception ex){ex.printStackTrace(); }
			sequencer.start();
		}
	}
	public class stoplistener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			sequencer.stop();
		}
	}
	public class tempouplistener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			float tempo = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempo*1.03));
		}
	}
	public class tempodownlistener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			float tempo = sequencer.getTempoFactor();
			sequencer.setTempoFactor((float)(tempo*.97));
		}
	}
	public class savelistener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			try {	
				ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ("mygame.ser"));
				oos.writeObject(checkboxlist);
				oos.close();
			} catch (IOException ex){ex.printStackTrace();}
		}
	}
	public class restorelistener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			ArrayList<JCheckBox> checkboxlist2 = new ArrayList<JCheckBox>();
			try { 
				ObjectInputStream oislocal = new ObjectInputStream (new FileInputStream ("mygame.ser"));
				checkboxlist2 = (ArrayList<JCheckBox>) oislocal.readObject();
				oislocal.close();
			} catch(Exception ex) {ex.printStackTrace();}	
			int k =0;
			for(int i=0;i<16; i++) {
				for(int j=0; j<20;j++){
					if(checkboxlist2.get(k).isSelected()){
						checkboxlist.get(k).setSelected(true);
					}
					else {
						checkboxlist.get(k).setSelected(false);
					}
					k++;
				}
			}
		}
	}
	public class sendlistener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			String message = null;
			message = chatinput.getText();
			boolean[] listtosend = new boolean[320];
			int k = 0;
			for(int i=0; i<16; i++){
				for(int j =0; j<20; j++) {
					if(checkboxlist.get(k).isSelected()){
						listtosend[k] = true;
						k++;
					}
					else {
						listtosend[k] = false;
						k++;
					}
				}
			}
			try{
				ous.writeObject(message);
				ous.writeObject(listtosend);
			} catch (Exception ex) { ex.printStackTrace(); }

			chatinput.setText("");
		}
	}
	public class resetlistener implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			int k =0;
			for(int i= 0;i<16;i++){
				for (int j=0; j<20; j++){
					JCheckBox checkbox = new JCheckBox();
					checkbox = checkboxlist.get(k);
					checkbox.setSelected(false);
					k++;
				}
			}
		}
	}
}
			

		
	
		
		






		
