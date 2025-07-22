package main;
import piece.Pawn;
import type.ColorType;
import utils.Constants;

public class Board {
	final int rows = Constants.BOARD_ROWS;
	final int columns = Constants.BOARD_COLUMNS;
	Cell[][] board;
	
	Pawn[] whitePiece;
	Pawn[] blackPiece;
 	
	public Board() {
		init();
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

//	public void printBoard() {
//		for(int i = 0; i<=9 ; i++) {
//			for(int j = 0; j<=9 ; j++) {
//				if(board[i][j].getPiece() == null) {
//					System.out.print(" - ");
//				} else {
////					System.out.print(board[i][j].getPiece().getColor());
//					System.out.print("["+ board[i][j].getPiece().getX() +","+ board[i][j].getPiece().getY() + "," + board[i][j].getPiece().getColor() +"]");
//				}
//			}
//			System.out.println();
//		}
//	}
}
