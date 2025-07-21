package main;
import piece.Piece;
import type.ColorType;

public class Cell {
	private int rowPos;
	private int colPos;
	private ColorType color;
	private Piece piece;
	
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public ColorType getColor() {
		return color;
	}

	public void setColor(ColorType color) {
		this.color = color;
	}

	public Cell(int rowPos, int colPos) {
		this.rowPos = rowPos;
		this.colPos = colPos;
	}

	public int getRowPos() {
		return rowPos;
	}

	public void setRowPos(int rowPos) {
		this.rowPos = rowPos;
	}

	public int getColPos() {
		return colPos;
	}

	public void setColPos(int colPos) {
		this.colPos = colPos;
	}	
	
}
