package com.axolotl.model;

public class Board {
	//6x6 Grid
	//16 Edges
	//16 Pieces
	//4 Unusable squares
	public AbstractPiece [][] board = new AbstractPiece[6][6];
	
	public Board(SidePiece ...sides) {
		if(sides.length != 16){
			throw new RuntimeException();
		}
		board[0][0] = new NullPiece();
		board[0][5] = new NullPiece();
		board[5][0] = new NullPiece();
		board[5][5] = new NullPiece();
		
		board[1][0] = sides[0];
		board[2][0] = sides[1];
		board[3][0] = sides[2];
		board[4][0] = sides[3];
		board[1][5] = sides[4];
		board[2][5] = sides[5];
		board[3][5] = sides[6];
		board[4][5] = sides[7];
		
		board[0][1] = sides[8];
		board[0][2] = sides[9];
		board[0][3] = sides[10];
		board[0][4] = sides[11];
		board[5][1] = sides[12];
		board[5][2] = sides[13];
		board[5][3] = sides[14];
		board[5][4] = sides[15];
		
	}
	
	public boolean placePiece(Piece piece, int x, int y) {
		boolean isPlacable = true;
		if(board[x-1][y] != null) {
			isPlacable=isPlacable&board[x-1][y].getColour(Side.RIGHT).equals(piece.getColour(Side.LEFT));
		} 
		
		if(board[x][y-1] != null)
		{
			isPlacable = isPlacable & board[x][y-1].getColour(Side.BOTTOM).equals(piece.getColour(Side.TOP));
		} 
		if(board[x+1][y] != null)
		{
			isPlacable = isPlacable & board[x+1][y].getColour(Side.LEFT).equals(piece.getColour(Side.RIGHT));
		} 
		if(board[x][y+1] != null)
		{
			isPlacable = isPlacable & board[x][y+1].getColour(Side.TOP).equals(piece.getColour(Side.BOTTOM));
		} 
		if(isPlacable) {
			board[x][y] = piece;
			return true;
		} else {
			return false;
		}
	}

	public void removePiece(int x, int y) {
		board[x][y] = null;
	}
	
	public AbstractPiece getPiece(int x, int y) {
		return board[x][y];
	}
}
