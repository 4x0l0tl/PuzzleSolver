package com.axolotl;
import java.util.Random;

import com.axolotl.model.Board;
import com.axolotl.model.Colour;
import com.axolotl.model.Piece;
import com.axolotl.model.Side;
import com.axolotl.model.SidePiece;

public class Generator {
	public static Board generateEmptyBoard() {
		SidePiece [] sides = new SidePiece[16];
		for(int i=0;i<16;i++) {
			sides[i] = new SidePiece(Colour.getRandomColour());
		}
		return new Board(sides);
	}
	
	public static Board generateFullBoard(){
		Board initialBoard = generateEmptyBoard();
		for(int x=1; x<initialBoard.board.length-1; x++) {
			for(int y=1; y<initialBoard.board[x].length-1; y++) {
				Piece piece =  new Piece();
				if(initialBoard.board[x-1][y] != null) {
					piece.addColour(initialBoard.board[x-1][y].getColour(Side.RIGHT));
				} else {
					piece.addColour(Colour.getRandomColour());
				}
					
				if(initialBoard.board[x][y-1] != null)
				{
					piece.addColour(initialBoard.board[x][y-1].getColour(Side.BOTTOM));
				} else {
					piece.addColour(Colour.getRandomColour());
				}
				if(initialBoard.board[x+1][y] != null)
				{
					piece.addColour(initialBoard.board[x+1][y].getColour(Side.LEFT));
				} else {
						piece.addColour(Colour.getRandomColour());
					}
				if(initialBoard.board[x][y+1] != null)
				{
					piece.addColour(initialBoard.board[x][y+1].getColour(Side.TOP));
				} else {
					piece.addColour(Colour.getRandomColour());
				}
				initialBoard.board[x][y] = piece;
			}
		}
		return initialBoard;
	}
	
	public static int generateNumOfRotations(){
		Random r = new Random();
		return r.nextInt(4);
	}
}
