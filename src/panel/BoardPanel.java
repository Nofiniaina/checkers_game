package panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import main.Board;
import type.ColorType;
import utils.Constants;



public class BoardPanel extends JPanel {
	
	Board board;
	
	public BoardPanel() {
		
		this.board = new Board();
		
		this.setFocusable(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		drawBoard(g2);
		drawPiece(g2);
	}
	
	public void drawBoard(Graphics2D g2) {
		int boardPanelWidth = getWidth();
		int boardPanelHeight = getHeight();
		
		int cellSize = Math.min(boardPanelWidth/12, boardPanelHeight/12);
		
		int x = (boardPanelWidth - (cellSize * Constants.BOARD_COLUMNS)) / 2;
		int y = cellSize;

		for (int row = 0; row < Constants.BOARD_ROWS; row++) {
            for (int col = 0; col < Constants.BOARD_COLUMNS; col++) {
            	
            	if(this.board.getCell(row, col).getColor() == ColorType.WHITE) {
            		
            		g2.setColor(Constants.lightSquare);
            		g2.fillRect(x, y, cellSize, cellSize);
            		
            	} else {
            		
            		g2.setColor(Constants.darkSquare);
            		g2.fillRect(x, y, cellSize, cellSize);
            		
            	}
            	x += cellSize;
            }
            x = (boardPanelWidth - (cellSize * Constants.BOARD_COLUMNS)) / 2;
            y += cellSize;
            
        }
	}
	
	public void drawPiece(Graphics2D g2) {
		int boardPanelWidth = getWidth();
		int boardPanelHeight = getHeight();
		
		int cellSize = Math.min(boardPanelWidth/12, boardPanelHeight/12);
		
		int x = (boardPanelWidth - (cellSize * Constants.BOARD_COLUMNS)) / 2;
		int y = cellSize;
		int padding = cellSize / 6;
		
		for (int row = 0; row < Constants.BOARD_ROWS; row++) {
            for (int col = 0; col < Constants.BOARD_COLUMNS; col++) {
            	
            	if(this.board.getCell(row, col).getPiece() != null){
            		if(this.board.getCell(row, col).getPiece().getColor() == ColorType.BLACK) {
            			g2.setColor(Color.BLACK);
            			g2.fillOval(x + padding, y + padding, cellSize - 2 * padding, cellSize - 2 * padding);
            		} else {
            			g2.setColor(Color.WHITE);
            			g2.fillOval(x + padding, y + padding, cellSize - 2 * padding, cellSize - 2 * padding);
            		}
            	}
              	
            	x += cellSize;
            }
            
            x = (boardPanelWidth - (cellSize * Constants.BOARD_COLUMNS)) / 2;
            y += cellSize;
            
        }
	}
}
