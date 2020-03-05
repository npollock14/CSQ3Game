
public class InputManager {

	static Point mPos = new Point(0, 0);
	static boolean[] mouse = new boolean[10];
	static boolean[] keys = new boolean[300];
	static boolean[] keysReleased = new boolean[300];
	static boolean[] keysToggled = new boolean[300];

	public void update() {

	}

	public static void updateKeyReleased(int e) {
		keysReleased[e] = true;

		keys[e] = false;

		if (keysToggled[e]) {
			keysToggled[e] = false;
		} else {
			keysToggled[e] = true;
		}

	}

}
