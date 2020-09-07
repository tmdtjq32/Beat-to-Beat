package mybeat;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StartGames extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	private Image Background = new ImageIcon(Main.class.getResource("../images/start.jpg")).getImage();
	
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/bar.jpg")));
	private ImageIcon exitdefault = new ImageIcon(Main.class.getResource("../images/exit.jpg"));
	private ImageIcon exitafter = new ImageIcon(Main.class.getResource("../images/exiticonafter.jpg"));
	
	private ImageIcon startdefault = new ImageIcon(Main.class.getResource("../images/starticon.jpg"));
	private ImageIcon startafter = new ImageIcon(Main.class.getResource("../images/startenter.jpg"));
	private ImageIcon quitdefault = new ImageIcon(Main.class.getResource("../images/exiticon.jpg"));
	private ImageIcon quitafter = new ImageIcon(Main.class.getResource("../images/exitenter.jpg"));
	private ImageIcon leftButtonBasic = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEntered = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasic = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEntered = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon easyButtonBasic = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easyButtonEntered = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon hardButtonBasic = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardButtonEntered = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));	
	private ImageIcon backButtonBasic = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEntered = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));	
	
	private JButton title = new JButton(new ImageIcon(Main.class.getResource("../images/title.png")));
	private JButton exiticon = new JButton(exitdefault);
	private JButton starticon = new JButton(startdefault);
	private JButton quiticon = new JButton(quitdefault);
	private JButton leftbutton = new JButton(leftButtonBasic);
	private JButton rightbutton = new JButton(rightButtonBasic);
	private JButton easybutton = new JButton(easyButtonBasic);
	private JButton hardbutton = new JButton(hardButtonBasic);
	private JButton backButton = new JButton(backButtonBasic);
	
	private int mouseX, mouseY;
	
	private boolean isMainscreen = false;
	private boolean isGamescreen = false;
	
	ArrayList<Track> trackList = new ArrayList<Track>();

	private Image titleimage;
	private Image selectedimage;
	private Music selectedMusic;
	private int nowSelected = 0;
	
	private Music intro = new Music("INTRO.mp3", true);
	
	public static Game game;
	
	public StartGames() {
		trackList.add(new Track("Baby title.png", "Blues Explosion.png", "Blues Explosion back.png",
				"The Jon Spencer Blues Explosion - Bellbottoms selected.mp3",
				"The Jon Spencer Blues Explosion - Bellbottoms.mp3", "The Jon Spencer Blues Explosion"));
		trackList.add(new Track("best title.png", "Best Friend.png", "Best Friend back.png",
				"SOFI TUKKER - Best Friend feat. NERVO, The Knocks  Alisa Ueno (Official Audio) selected.mp3",
				"SOFI TUKKER - Best Friend feat. NERVO, The Knocks  Alisa Ueno (Official Audio).mp3","Best Friend"));
		trackList.add(new Track("Tango title.png", "tango.png", "tango back.png",
				"Tango - Abir selected.mp3", "Tango - Abir.mp3", "Tango"));		
		trackList.add(new Track("Ice cream title.png", "ice cream.png", "ice cream back.png",
				"BLACKPINK - 'Ice Cream (with Selena Gomez)' selected.mp3",
				"BLACKPINK - 'Ice Cream (with Selena Gomez)'.mp3","Ice Cream"));		
		setUndecorated(true);
		setTitle("Beat To Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		addKeyListener(new KeyListener());
		
		intro.start();
		
		title.setBounds(343, 0, 200, 50);
		title.setBorderPainted(false);
		title.setContentAreaFilled(false);
		title.setFocusPainted(false);
		title.setOpaque(false);
		add(title);
		
		leftbutton.setVisible(false);
		leftbutton.setBounds(100, 300, 60, 60);
		leftbutton.setBorderPainted(false);
		leftbutton.setContentAreaFilled(false);
		leftbutton.setFocusPainted(false);
		leftbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftbutton.setIcon(leftButtonEntered);
				leftbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftbutton.setIcon(leftButtonBasic);
				leftbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		add(leftbutton);
		
		rightbutton.setVisible(false);
		rightbutton.setBounds(750, 300, 60, 60);
		rightbutton.setBorderPainted(false);
		rightbutton.setContentAreaFilled(false);
		rightbutton.setFocusPainted(false);
		rightbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightbutton.setIcon(rightButtonEntered);
				rightbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightbutton.setIcon(rightButtonBasic);
				rightbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		add(rightbutton);
		
		easybutton.setVisible(false);
		easybutton.setBounds(180, 500, 250, 67);
		easybutton.setBorderPainted(false);
		easybutton.setContentAreaFilled(false);
		easybutton.setFocusPainted(false);
		easybutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easybutton.setIcon(easyButtonEntered);
				easybutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easybutton.setIcon(easyButtonBasic);
				easybutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected,"Easy");
			}
		});
		add(easybutton);
		
		hardbutton.setVisible(false);
		hardbutton.setBounds(480, 500, 250, 67);
		hardbutton.setBorderPainted(false);
		hardbutton.setContentAreaFilled(false);
		hardbutton.setFocusPainted(false);
		hardbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardbutton.setIcon(hardButtonEntered);
				hardbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardbutton.setIcon(hardButtonBasic);
				hardbutton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				gameStart(nowSelected,"Hard");
			}
		});
		add(hardbutton);
		
		backButton.setVisible(false);
		backButton.setBounds(40, 40, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEntered);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasic);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				backMain();
			}
		});
		add(backButton);
		
		exiticon.setBounds(830, 0, 50, 50);
		exiticon.setBorderPainted(false);
		exiticon.setContentAreaFilled(false);
		exiticon.setFocusPainted(false);
		exiticon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exiticon.setIcon(exitafter);
				exiticon.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exiticon.setIcon(exitdefault);
				exiticon.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(exiticon);
		
		quiticon.setBounds(40, 140, 200, 50);
		quiticon.setBorderPainted(false);
		quiticon.setContentAreaFilled(false);
		quiticon.setFocusPainted(false);
		quiticon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quiticon.setIcon(quitafter);
				quiticon.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quiticon.setIcon(quitdefault);
				quiticon.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});
		add(quiticon);
		
		starticon.setBounds(40, 80, 200, 50);
		starticon.setBorderPainted(false);
		starticon.setContentAreaFilled(false);
		starticon.setFocusPainted(false);
		starticon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				starticon.setIcon(startafter);
				starticon.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				starticon.setIcon(startdefault);
				starticon.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				enterMain();
			}
		});
		add(starticon);
		
		menubar.setBounds(0, 0, 900, 50);
		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menubar);
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(Background, 0, 0, null);
		if (isMainscreen) {
			g.drawImage(selectedimage, 220, 180, null);
			g.drawImage(titleimage, 300, 120, null);
		}
		if (isGamescreen) {
			game.screenDraw(g);
			
		}
		paintComponents(g);
		try {
			Thread.sleep(10);
		}
		catch (Exception e){
			e.printStackTrace();
		}
		this.repaint();
	}
	
	public void selectTrack(int nowSelected) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		titleimage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage())).getImage();
		selectedimage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage())).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft() {
		if (nowSelected == 0) {
			nowSelected = trackList.size() - 1;
		}
		else {
			nowSelected--;
		}
		selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if (nowSelected == trackList.size() - 1) {
			nowSelected = 0;
		}
		else {
			nowSelected++;
		}
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null) {
			selectedMusic.close();
		}
		isMainscreen = false;
		leftbutton.setVisible(false);
		rightbutton.setVisible(false);
		easybutton.setVisible(false);
		hardbutton.setVisible(false);
		Background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
		isGamescreen = true;
		game = new Game(trackList.get(nowSelected).getTitle(), difficulty, trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);
	}
	
	public void backMain() {
		isMainscreen = true;
		leftbutton.setVisible(true);
		rightbutton.setVisible(true);
		easybutton.setVisible(true);
		hardbutton.setVisible(true);
		Background = new ImageIcon(Main.class.getResource("../images/main.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGamescreen = false;
		game.close();
	}
	
	public void enterMain() {
		starticon.setVisible(false);
		quiticon.setVisible(false);
		Background = new ImageIcon(Main.class.getResource("../images/main.jpg")).getImage();
		isMainscreen = true;
		leftbutton.setVisible(true);
		rightbutton.setVisible(true);
		easybutton.setVisible(true);
		hardbutton.setVisible(true);
		intro.close();	
		selectTrack(0);
	}
}
