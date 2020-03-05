import java.awt.Color;
import java.awt.Graphics;

public class MenuScene extends Scene {
	Button start;

	@Override
	public void draw(Graphics g) {
		g.setFont(Misc.fBig);
		g.setColor(Color.BLACK);
		g.drawString("Start Game", Driver.screenWidth / 2, Driver.screenHeight / 2);
		
		start.draw(g, 0, 0);
		if (start.clicked) {
			g.drawString("CLICK", Driver.screenWidth / 2, Driver.screenHeight / 2 + 500);
		}

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		start.update(InputManager.mouse, InputManager.mPos, InputManager.mouseReleased);

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		start = new Button(new Rect(Driver.screenWidth/2 - 150, Driver.screenHeight/2 - 60, 300,120), null,0,"Start", Driver.f, Color.BLACK, true);
		

	}

}
