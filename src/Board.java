import type.ColorType;
import utils.GameConstants;

public class Board {
	int rows = GameConstants.BOARD_ROWS;
	int columns = GameConstants.BOARD_COLUMNS;
	Cell[][] board;
	
	
	
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
		
		for(int i = 0; i<=3 ; i++) {
			for(int j = 0; j<columns ; j++) {
				
			}
		}
		for(int i = 6; i<=9 ; i++) {
			for(int j = 0; j<columns ; j++) {
				
			}
		}
	} 
 
	// this is just a test 
	public void printBoard() {
		for(int i = 0; i<rows ; i++) {
			for(int j = 0; j<columns ; j++) {
				System.out.print(this.board[i][j].getColor() + " ");
			}
			System.out.println();
		}
	}
}
