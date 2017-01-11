package com.axolotl;
import java.util.Queue;

import com.axolotl.model.Board;
import com.axolotl.model.Piece;

public class Solver {

	public Board solveBoard(Board emptyBoard, Queue<Piece> pieces) {
		placePiece(emptyBoard, pieces, 1, 1);
		return emptyBoard;
	}
	
	private  boolean placePiece(Board board, Queue<Piece> unusedPieces,int x, int y) {
		if(unusedPieces.isEmpty()) {
			return true;
		}
		int count = unusedPieces.size();
		
		while(! unusedPieces.isEmpty() && count > 0) {
			Piece p = unusedPieces.remove();
			int tempX = x;
			int tempY = y;
			while(p.getNumberOfPieceRotations() < 4) {
				if(board.placePiece(p, x, y)) {
					if(x < 4) {
						tempX += 1;
					}
					else if(x == 4 && y < 4) {
						tempX = 1;
						tempY += 1;
					}
					
					if(!placePiece(board, unusedPieces, tempX, tempY)){
						board.removePiece(x, y);
						p.rotate();
						tempX = x;
						tempY = y;
					} else {
						return true;
					}
				} else if (p.getNumberOfPieceRotations() < 4) {
					p.rotate();
				}
			}
			p.resetRotationCount();
			unusedPieces.add(p);
			count = count-1;
		}
		return false;
	}
}
