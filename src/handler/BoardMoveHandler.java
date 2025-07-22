package handler;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.Board;
import main.Cell;
import panel.BoardPanel;
import piece.Piece;
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
	                board.getCell(selectedPiece.getX(), selectedPiece.getY()).setPiece(null);
	                selectedPiece.setX(row);
	                selectedPiece.setY(col);
	                clickedCell.setPiece(selectedPiece);
	                selectedPiece = null;
	            }
	        }

	        boardpanel.repaint();
	    }
	}
	
}
