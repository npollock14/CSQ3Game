import java.awt.Graphics;
import java.util.ArrayList;

public class SceneManager {
	static ArrayList<Scene> scenes = new ArrayList<Scene>();
	
	
	public static void update() {
		for(Scene s : scenes) {
			if(s.running) s.update();
		}
	}
	public static void draw(Graphics g) {
		for(Scene s : scenes) {
			if(s.running) s.draw(g);
		}
	}
	
}
