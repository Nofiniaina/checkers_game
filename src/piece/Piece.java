package piece;
import type.ColorType;

public class Piece {
	protected int x;
	protected int y;
	protected ColorType color;
	protected boolean dead = false;
	
	public Piece(ColorType color) {
		this.color = color;
	}
	
	public boolean isDead() {
		return dead;
	}

	public void setDead(boolean dead) {
		this.dead = dead;
	}

	public ColorType getColor() {
		return color;
	}

	public void setColor(ColorType color) {
		this.color = color;
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
	
	protected void move() {
		
	}
	
	public boolean validateMove() {
		return true;
	}
}
