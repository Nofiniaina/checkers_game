package piece;
import type.ColorType;

public class Piece {
	protected int x;
	protected int y;
	protected ColorType color;
	
	public ColorType getColor() {
		return color;
	}

	public void setColor(ColorType color) {
		this.color = color;
	}

	public Piece() {
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
}
