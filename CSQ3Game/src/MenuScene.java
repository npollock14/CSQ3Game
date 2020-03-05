import java.awt.Color;
import java.awt.Graphics;

public class MenuScene extends Scene{

	@Override
	public void draw(Graphics g) {
		g.setFont(Misc.fBig);
		g.setColor(Color.BLACK);
		g.drawString("MENU", Driver.screenWidth/2, Driver.screenHeight/2);
		if(InputManager.mouse[1]) {
			g.drawString("CLICK", Driver.screenWidth/2, Driver.screenHeight/2 + 500);
		}
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
