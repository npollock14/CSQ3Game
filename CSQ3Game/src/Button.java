import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

class Button {
	Rect bounds;
	BufferedImage img;
	int centeringMethod;
	boolean clicked, glowing, glow;
	String text = "";
	Font f = new Font("Arial", 0, 12);
	Color c;

	public Button(Rect bounds, BufferedImage img, int centeringMethod, String text, Font f, Color c, boolean glow) {
		super();
		this.bounds = bounds;
		this.img = img;
		this.centeringMethod = centeringMethod;
		this.text = text;
		this.f = f;
		this.c = c;
		this.glow = glow;
	}

	public void update() {
		if (InputManager.mouseReleased[1] && InputManager.mPos.inside(bounds)) {
			clicked = true;
		} else {
			clicked = false;
		}
		if(InputManager.mPos.inside(bounds) && glow) {
			glowing = true;
		}else {
			glowing = false;
		}
	}

	public void draw(Graphics g, int xOff, int yOff) {
		g.setColor(c);
		if(glowing) g.setColor(Color.blue);
		g.fillRoundRect((int)bounds.pos.x, (int)bounds.pos.y, (int)bounds.w, (int)bounds.h, 10, 10);
		g.setColor(Color.black);
		g.drawRoundRect((int)bounds.pos.x, (int)bounds.pos.y, (int)bounds.w, (int)bounds.h, 10, 10);
		if(img!=null) g.drawImage(img, (int)bounds.pos.x, (int)bounds.pos.y, bounds.w < bounds.h ? (int)bounds.w : (int)bounds.h, bounds.w < bounds.h ? (int)bounds.w : (int)bounds.h, null);
		if(text!=null)g.drawString(text, (int)(bounds.pos.x + xOff), (int)(bounds.pos.y + yOff));
	}

}