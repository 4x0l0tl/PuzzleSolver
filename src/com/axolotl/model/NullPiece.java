package com.axolotl.model;

public class NullPiece implements AbstractPiece, PieceIdentifier{

	@Override
	public boolean isNullPiece() {
		return true;
	}

	@Override
	public boolean isSidePiece() {
		return false;
	}

	@Override
	public boolean isBoardPiece() {
		return false;
	}

	@Override
	public Colour getColour(Side side) {
		return null;
	}
	
}
