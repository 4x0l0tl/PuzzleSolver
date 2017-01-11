package com.axolotl.model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Piece implements AbstractPiece,PieceIdentifier {
	Queue<Colour> sides = new LinkedList<Colour>();
	int rotations = 0;
	
	public void addColour(Colour colour) {
		if(sides.size() < 4) {
			sides.add(colour);
		}
	}
	
	public void rotate() {
		Colour side = sides.remove();
		sides.add(side);
		rotations +=1;
	}
	
	public int getNumberOfPieceRotations() {
		return rotations;
	}
	
	public void resetRotationCount() {
		rotations = 0;
	}

	@Override
	public boolean isNullPiece() {
		return false;
	}

	@Override
	public boolean isSidePiece() {
		return false;
	}

	@Override
	public boolean isBoardPiece() {
		return true;
	}

	@Override
	public Colour getColour(Side side) {
		List<Colour> c = new ArrayList<>(sides);
		return c.get(side.ordinal());
	}
	
	
}
