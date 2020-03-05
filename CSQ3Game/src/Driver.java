import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Driver extends JPanel
		implements ActionListener, KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {
	static Font f = new Font("Press Start", 0, 48);
	static int screenWidth = 1800;
	static int screenHeight = 1000;

	// ============== end of settings ==================
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		SceneManager.draw(g);
	}

	public void update() throws InterruptedException {
		SceneManager.update();

		
	}

	private void init() {
		SceneManager.scenes.add(new MenuScene());
		
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

		JFrame f = new JFrame();
		f.setTitle("Name");
		f.setSize(screenWidth, screenHeight);
		f.setBackground(Color.BLACK);
		f.setResizable(false);
		f.addKeyListener(this);
		f.addMouseMotionListener(this);
		f.addMouseWheelListener(this);
		f.addMouseListener(this);

		f.add(this);

		t = new Timer(14, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	Timer t;

	@Override
	public void keyPressed(KeyEvent e) {
		InputManager.keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		InputManager.updateKeyReleased(e.getKeyCode());
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
		// InputManager.mouseReleased[e.getButton()] = true;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		InputManager.mouse[e.getButton()] = true;

	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

}
