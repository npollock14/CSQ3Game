import java.awt.Graphics;
import java.util.ArrayList;

public class SceneManager {
	static ArrayList<Scene> scenes = new ArrayList<Scene>();
	static MenuScene ms = new MenuScene();
	static GameScene gs = new GameScene();

	public static void update() {
		for (Scene s : scenes) {
			if (s.running)
				s.update();
		}
	}

	public static void draw(Graphics g) {
		for (Scene s : scenes) {
			if (s.running)
				s.draw(g);
		}
	}

	public static void initScenes(boolean all) {
		for (Scene s : scenes) {
			if (all) {
				s.init();
			} else if (!s.init) {
				s.init();
			}

		}
	}
	public static void initManager() {
		scenes.add(ms);
		scenes.add(gs);
	}

}
