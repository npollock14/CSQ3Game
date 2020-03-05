import java.awt.Graphics;

public abstract class Scene {
	
	boolean running = true;
	boolean drawing = true;
	
	public abstract void draw(Graphics g);
	public abstract void update();
	public abstract void init();
}
