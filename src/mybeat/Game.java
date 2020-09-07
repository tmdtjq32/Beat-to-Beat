package mybeat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLine = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteLine = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();

	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteG1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteG2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteHImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	private boolean gameMaker = true; 
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 117, 50, null);
		g.drawImage(noteRouteLine, 197, 50, null);
		g.drawImage(noteRouteDImage, 199, 50, null);
		g.drawImage(noteRouteLine, 279, 50, null);
		g.drawImage(noteRouteFImage, 281, 50, null);
		g.drawImage(noteRouteLine, 361, 50, null);
		g.drawImage(noteRouteG1Image, 363, 50, null);
		g.drawImage(noteRouteG2Image, 443, 50, null);
		g.drawImage(noteRouteLine, 523, 50, null);
		g.drawImage(noteRouteHImage, 525, 50, null);
		g.drawImage(noteRouteLine, 605, 50, null);
		g.drawImage(noteRouteJImage, 607, 50, null);
		g.drawImage(noteRouteLine, 687, 50, null);
		g.drawImage(noteRouteKImage, 689, 50, null);
		g.drawImage(gameInfoImage, 0, 540, null);
		g.drawImage(judgementLine, 0, 470, null);
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			note.screenDraw(g);
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(titleName,20,580);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 16));
		g.setColor(Color.darkGray);
		g.drawString("S", 150, 490);
		g.drawString("D", 232, 490);
		g.drawString("F", 315, 490);
		g.drawString("G", 434, 490);
		g.drawString("H", 559, 490);
		g.drawString("J", 641, 490);
		g.drawString("K", 723, 490);

		g.setFont(new Font("Elephant",Font.BOLD, 20));
		g.drawString("000000",415,580);
	}
	
	public void pressS() {
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " S");
		}
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumsmall1.mp3", false).start();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressD() {
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " D");
		}
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3", false).start();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressF() {
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " F");
		}
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
	}
	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressG() {
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " G");
		}
		noteRouteG1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteG2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall3.mp3", false).start();
	}
	public void releaseG() {
		noteRouteG1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteG2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressH() {
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " H");
		}
		noteRouteHImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig2.mp3", false).start();
	}
	public void releaseH() {
		noteRouteHImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressJ() {
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " J");
		}
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig3.mp3", false).start();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	public void pressK() {
		if (gameMaker == true) {
			System.out.println(gameMusic.getTime() + " K");
		}
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	@Override
	public void run() {
		dropNotes();
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes() {
		Beat[] beat = null;
		if (titleName.equals("The Jon Spencer Blues Explosion")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 100;
			beat = new Beat[] {
					new Beat(startTime,"S"),
					new Beat(startTime + gap*2,"GL")
					
			};
		}
		else if (titleName.equals("Best Friend")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 100;
			beat = new Beat[] {
					new Beat(startTime,"S")
					
			};
		}
		else if (titleName.equals("Tango")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 100;
			beat = new Beat[] {
					new Beat(startTime,"S")
					
			};
		}
		else if (titleName.equals("Ice Cream")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beat = new Beat[] {
					new Beat(0,"S"),
					new Beat(250,"D"),
					new Beat(430,"D"),
					new Beat(750,"S"),
					new Beat(1000 ,"D"),
					new Beat(1180 ,"D"),
					new Beat(1570 ,"F"),
					new Beat(1720 ,"D"),
					new Beat(2330,"S"),
					new Beat(2330+250,"D"),
					new Beat(2330+430,"D"),
					new Beat(2330+750,"S"),
					new Beat(2330+1000 ,"D"),
					new Beat(2330+1180 ,"D"),
					new Beat(2330+1570 ,"F"),
					new Beat(2330+1720 ,"D"),
					
					
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beat.length && !isInterrupted()) {
			boolean dropped = false;
			if(beat[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beat[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try{
					Thread.sleep(10);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
