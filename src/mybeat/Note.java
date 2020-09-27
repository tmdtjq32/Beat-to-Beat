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
	private boolean proceeded = true;
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
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
				g.drawImage(noteBasic, x, y, null);
				g.drawImage(noteBasic, x, y+40, null);
				g.drawImage(noteBasic, x, y+80, null);
			}
		}
		else {
			if (noteType.equals("G")) {
				g.drawImage(noteWide, x, y, null);
			}
			else {
				g.drawImage(noteWide, x, y, null);
				g.drawImage(noteWide, x, y+40, null);
				g.drawImage(noteWide, x, y+40, null);
			}
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED;
		if (y > 545) {
			System.out.println("Miss");
			close();
		}
	}
	
	public void run() {
		try {
			while (true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void judge(String input) {
		if (y >= 530) {
			System.out.println("Late");
			close();
		}
		else if (y >= 515) {
			System.out.println("Good");
			close();
		}
		else if (y >= 500) {
			System.out.println("Great");
			close();
		}
		else if (y >= 470) {
			System.out.println("Excellent!");
			close();
		}
		else if (y >= 455) {
			System.out.println("Great!");
			close();
		}
		else if (y >= 440) {
			System.out.println("Good");
			close();
		}
		else if (y >= 425) {
			System.out.println("Too early");
			close();
		}
	}
	
	
}
