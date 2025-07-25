package handler;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.Board;
import main.Cell;
import panel.BoardPanel;
import piece.Piece;
import type.ColorType;
import utils.Constants;

public class BoardMoveHandler extends MouseAdapter {
	
	private BoardPanel boardpanel;
	private Board board;
	private Piece selectedPiece = null;
	
	public BoardMoveHandler(BoardPanel boardpanel) {
		this.boardpanel = boardpanel;
		this.board = boardpanel.getBoard();
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int cellSize = Math.min(boardpanel.getWidth() / 12, boardpanel.getHeight() / 12);
		
		int x = (boardpanel.getWidth() - (cellSize * Constants.BOARD_COLUMNS)) / 2;
		int y = cellSize;
		
		int col = (e.getX() - x) / cellSize;
		int row = (e.getY() - y) / cellSize;
		
		if (row >= 0 && row < Constants.BOARD_ROWS && col >= 0 && col < Constants.BOARD_COLUMNS) {
	        Cell clickedCell = board.getCell(row, col);
	        Piece piece = clickedCell.getPiece();

	        if (selectedPiece == null) {
	            if (piece != null) {
	                selectedPiece = piece;
	            }
	        } else {
	            if (piece == null) {
	            	if(clickedCell.getColor() == ColorType.BLACK) {
	            		
	            		if(selectedPiece.getColor() == board.getTurn()) {
	            			boolean validateMove = board.validateMove(selectedPiece, row, col);
		            		boolean validateAttack = board.validateAttack(selectedPiece, row, col);         
		            		
		            		if(validateMove || validateAttack) {
		            			board.getCell(selectedPiece.getX(), selectedPiece.getY()).setPiece(null);
		            			
		            			if(validateAttack) {
		            				board.defaultAttack(selectedPiece, row, col);
		            			}
		            			
		            			selectedPiece.setX(row);
				                selectedPiece.setY(col);
				                clickedCell.setPiece(selectedPiece);				 
				                
				                if(board.getTurn() == ColorType.WHITE) {
				                	board.setTurn(ColorType.BLACK);
				                } else if(board.getTurn() == ColorType.BLACK) {
				                	board.setTurn(ColorType.WHITE);
				                }
				                
				                selectedPiece = null;
		            		} else  {
		            			selectedPiece = null;
		            		}
	            		} else {
	            			selectedPiece = null;
	            		}	            		
	            		
	            	}
	                
	            }
	        }

	        boardpanel.repaint();
	    }
	}
	
}
