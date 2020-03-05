import java.awt.Color;
import java.awt.Graphics;

public class MenuScene extends Scene {
	Button start;

	@Override
	public void draw(Graphics g) {
		g.setFont(Misc.fBig);
		g.setColor(Color.BLACK);
		g.drawString("The Game", Driver.screenWidth / 2, Driver.screenHeight / 3);

		start.draw(g, 10, 100);
		if (start.clicked) {
			this.running = false;
			this.drawing = false;

			SceneManager.gs.running = true;
			SceneManager.gs.drawing = true;

			g.drawString("CLICK", Driver.screenWidth / 2, Driver.screenHeight / 2 + 500);
		}

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		start.update();

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		start = new Button(new Rect(Driver.screenWidth / 2 - 150, Driver.screenHeight / 2 - 60, 300, 120), null, 0,
				"Start", Driver.f, Color.white, true);

	}

}
