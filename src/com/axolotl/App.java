package com.axolotl;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

import com.axolotl.model.Board;
import com.axolotl.model.Piece;
import com.axolotl.model.Side;

public class App {
	public static void main (String [] args) {
		Board board;
		Queue<Piece> pieces = new LinkedList<Piece>();
		Solver solver = new Solver();
		if(args.length > 0) {
			board = Generator.generateFullBoard();
			List<Piece> unusedPieces = new LinkedList<Piece>();
			for(int x=1; x<board.board.length-1; x++) {
				for(int y=1; y<board.board[x].length-1; y++) {
					System.out.print(board.getPiece(x, y).getColour(Side.LEFT)+",");
					System.out.print(board.getPiece(x, y).getColour(Side.TOP)+",");
					System.out.print(board.getPiece(x, y).getColour(Side.RIGHT)+",");
					System.out.println(board.getPiece(x, y).getColour(Side.BOTTOM));
					Piece piece = (Piece) board.getPiece(x, y);
					board.board[x][y] = null;
					int numberOfPieceRotations = Generator.generateNumOfRotations();
					for(int r =0; r<numberOfPieceRotations; r++){
						piece.rotate();
					}
					piece.resetRotationCount();
					unusedPieces.add(piece);
				}
			}
			System.out.println("");
			Collections.shuffle(unusedPieces, new Random());
			for(Piece p : unusedPieces) {
				System.out.print(p.getColour(Side.LEFT)+",");
				System.out.print(p.getColour(Side.TOP)+",");
				System.out.print(p.getColour(Side.RIGHT)+",");
				System.out.println(p.getColour(Side.BOTTOM));
			}
			for(Piece p : unusedPieces) {
				pieces.add(p);
			}			
		} else {
			board = Reader.readBoard();
			pieces = Reader.readPieces();
		}
		solver.solveBoard(board, pieces);
		
		System.out.println("Solution:");
		for(int x=0; x<board.board.length; x++) {
			for(int y=0; y<board.board[x].length; y++) {
				System.out.print(board.getPiece(x, y).getColour(Side.LEFT)+",");
				System.out.print(board.getPiece(x, y).getColour(Side.TOP)+",");
				System.out.print(board.getPiece(x, y).getColour(Side.RIGHT)+",");
				System.out.println(board.getPiece(x, y).getColour(Side.BOTTOM));
			}
		}
	}
}
