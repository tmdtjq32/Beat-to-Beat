package mybeat;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {
	private Image noteBasic = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteBasicLong = new ImageIcon(Main.class.getResource("../images/noteBasicLong.png")).getImage();
	private Image noteWide = new ImageIcon(Main.class.getResource("../images/noteWide.png")).getImage();
	private Image noteWideLong = new ImageIcon(Main.class.getResource("../images/noteWideLong.png")).getImage();

	private int x, y = 500 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;	
	private String noteType;
	public Note(String noteType) {
		if (noteType.equals("S") || noteType.equalsIgnoreCase("SL")) {
			x = 117;
		}
		else if (noteType.equals("D") || noteType.equalsIgnoreCase("DL")) {
			x = 199;
		}
		else if (noteType.equals("F") || noteType.equalsIgnoreCase("FL")) {
			x = 281;
		}
		else if (noteType.equals("G") || noteType.equalsIgnoreCase("GL")) {
			x = 363;
		}
		else if (noteType.equals("H") || noteType.equalsIgnoreCase("HL")) {
			x = 525;
		}
		else if (noteType.equals("J") || noteType.equalsIgnoreCase("JL")) {
			x = 607;
		}
		else if (noteType.equals("K") || noteType.equalsIgnoreCase("KL")) {
			x = 689;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if (!(noteType.equals("G") || noteType.equals("GL"))) {
			if (!(noteType.equals("SL") || noteType.equalsIgnoreCase("DL") || noteType.equalsIgnoreCase("FL")
					|| noteType.equalsIgnoreCase("HL") || noteType.equalsIgnoreCase("JL")
					|| noteType.equalsIgnoreCase("KL"))) {
				g.drawImage(noteBasic, x, y, null);
			}
			else {
				g.drawImage(noteBasicLong, x, y, null);
			}
		}
		else {
			if (noteType.equals("G")) {
				g.drawImage(noteWide, x, y, null);
			}
			else {
				g.drawImage(noteWideLong, x, y, null);
			}
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
	}
	
	public void run() {
		try {
			while (true) {
				drop();
				Thread.sleep(Main.SLEEP_TIME);
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	
	
}
