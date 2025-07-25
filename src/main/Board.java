package main;
import piece.Pawn;
import piece.Piece;
import type.ColorType;
import utils.Constants;

public class Board {
	final int rows = Constants.BOARD_ROWS;
	final int columns = Constants.BOARD_COLUMNS;
	Cell[][] board;
	
	Pawn[] whitePiece;
	Pawn[] blackPiece;
 	
	ColorType turn;
	
	public Board() {
		init();
		this.turn = ColorType.WHITE;
	}
	
	public void init() {
		this.board = new Cell[rows][columns];
		
		for(int i = 0; i<rows ; i++) {
			for(int j = 0; j<columns ; j++) {
				this.board[i][j] = new Cell(i, j);
				if(i%2 == 0) {
					if(j%2 !=0) {
						this.board[i][j].setColor(ColorType.BLACK);
					} else {
						this.board[i][j].setColor(ColorType.WHITE);
					}
				} else {
					if(j%2 == 0) {
						this.board[i][j].setColor(ColorType.BLACK);
					} else {
						this.board[i][j].setColor(ColorType.WHITE);
					}
				}
			}
		}
		
		this.whitePiece = new Pawn[Constants.PIECE_NUMBER];
		this.blackPiece = new Pawn[Constants.PIECE_NUMBER];
		
		/* Initialize pawn array */
		for(int i = 0; i<20 ; i++) {
			this.whitePiece[i] = new Pawn(ColorType.WHITE);
			this.blackPiece[i] = new Pawn(ColorType.BLACK);
		}
		
		int pieceindex = 0;
		for(int i = 0; i<=3 ; i++) {
			for(int j = 0; j< columns ; j++) {
				if(this.board[i][j].getColor() == ColorType.BLACK) {
					this.board[i][j].setPiece(this.blackPiece[pieceindex]);
					
					this.board[i][j].getPiece().setX(i);
					this.board[i][j].getPiece().setY(j);
					
					pieceindex++;
				}
			}
		}
		
		pieceindex = 0;
		for(int i = 6; i<=9 ; i++) {
			for(int j = 0; j< columns ; j++) {
				if(this.board[i][j].getColor() == ColorType.BLACK) {
					this.board[i][j].setPiece(this.whitePiece[pieceindex]);
					
					this.board[i][j].getPiece().setX(i);
					this.board[i][j].getPiece().setY(j);
					
					pieceindex++;
				}
			}
		}
	} 
	
	public Cell[][] getBoard() {
		return board;
	}

	public Cell getCell(int x, int y) {
		return this.board[x][y];
	}
	
	public Pawn[] getWhitePiece() {
		return whitePiece;
	}

	public Pawn[] getBlackPiece() {
		return blackPiece;
	}

	public ColorType getTurn() {
		return turn;
	}

	public void setTurn(ColorType turn) {
		this.turn = turn;
	}

	public boolean validateMove(Piece piece, int destRow, int destCol) {
		int initialRow = piece.getX();
		int initialCol = piece.getY();
		if(piece.getColor() == ColorType.WHITE) {

			boolean leftMove = ((initialCol-1) == destCol) && ((initialRow-1) == destRow);
			boolean rightMove = ((initialCol+1) == destCol) && ((initialRow-1) == destRow);
			
			return (rightMove || leftMove);
		} else {
			boolean leftMove = ((initialCol-1) == destCol) && ((initialRow+1) == destRow);
			boolean rightMove = ((initialCol+1) == destCol) && ((initialRow+1) == destRow);
			
			return (rightMove || leftMove);
		}
		
	}
	
	public boolean validateAttack(Piece piece, int destRow, int destCol) {
		int initialRow = piece.getX();
		int initialCol = piece.getY();
		
		int diagonalRow = destRow - initialRow;
		int diagonalCol = destCol - initialCol;
		
		if(Math.abs(diagonalRow) == 2 && Math.abs(diagonalCol) == 2) {
			int enemyRow = (initialRow + destRow) / 2;
			int enemyCol = (initialCol + destCol) / 2;
			
			Piece enemyPiece = board[enemyRow][enemyCol].getPiece();
			if(enemyPiece != null) {
				if(enemyPiece.getColor() != piece.getColor() && board[destRow][destCol].getPiece() == null) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public void defaultAttack(Piece piece, int destRow, int destCol) {
		int initialRow = piece.getX();
		int initialCol = piece.getY();
		
		int enemyRow = (initialRow + destRow) / 2;
		int enemyCol = (initialCol + destCol) / 2;
		
		board[enemyRow][enemyCol].setPiece(null);
	}

}
