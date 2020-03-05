import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Driver extends JPanel
		implements ActionListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	static Font f = new Font("Press Start", 0, 48);
	static Font fs = new Font("Press Start", 0, 11);
	static int screenWidth = 1800;
	static int screenHeight = 1000;
	static Point windowLoc = new Point();
	static JFrame frame;
	ArrayList<Long> fps = new ArrayList<Long>();
	long frameStart = 0;
	//static boolean closeNormally = true;
	
	// ============== end of settings ==================
	
	public void paint(Graphics g) { //main paint
		super.paintComponent(g);
		SceneManager.draw(g);
		
		g.setFont(fs);
		fps.add((long) (1 / ((System.nanoTime() - frameStart) / Math.pow(10, 9))));
		if(fps.size() >= 60) {
			fps.remove(0);
		}
		double sum = 0;
		for(Long d : fps) {
			sum += d;
		}
		double avg = sum/fps.size();
		g.drawString((int)avg + "", screenWidth - 50, 25);
		frameStart = System.nanoTime();
		
	}

	public void update() throws InterruptedException { // main update
		SceneManager.update();
		windowLoc.setXY(frame.getLocation().x,frame.getLocation().y);
		//System.out.println(windowLoc.toString());
		
		
	}

	private void init() {
		SceneManager.initManager();
		SceneManager.initScenes(true);
		
//	Toolkit.getDefaultToolkit().beep();
		
	}

	

	// ==================code above ===========================

	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			InputManager.mPos = getMousePos();
			
			update();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repaint();
		InputManager.update();

	}
	public Point getMousePos() {
		try {
			return new Point(this.getMousePosition().x, this.getMousePosition().y);
		} catch (Exception e) {
			return InputManager.mPos;
		}
	}

	public static void main(String[] arg) {
		@SuppressWarnings("unused")
		Driver d = new Driver();
	}

	public Driver() {

		init();

		frame = new JFrame();
		frame.setTitle("CS Q3 Game");
		frame.setSize(screenWidth, screenHeight);
		frame.setBackground(Color.BLACK);
		frame.setResizable(false);
		frame.addKeyListener(this);
		frame.addMouseMotionListener(this);
		frame.addMouseWheelListener(this);
		frame.addMouseListener(this);

		frame.add(this);

		t = new Timer(1, this);
		t.start();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		InputManager.keys[e.getKeyCode()] = true;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		InputManager.setKeyReleased(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		InputManager.mouse[e.getButton()] = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		InputManager.mouse[e.getButton()] = false;
		InputManager.mouseReleased[e.getButton()] = true;
		InputManager.resetMouseReleased = true;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		InputManager.mouse[e.getButton()] = true;

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}
