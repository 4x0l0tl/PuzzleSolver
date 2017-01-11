package com.axolotl.model;

public class SidePiece implements AbstractPiece,PieceIdentifier{

	Colour colour;
	public SidePiece (Colour colour) {
		this.colour = colour;
	}
	@Override
	public boolean isNullPiece() {
		return false;
	}

	@Override
	public boolean isSidePiece() {
		return true;
	}

	@Override
	public boolean isBoardPiece() {
		return false;
	}
	
	@Override
	public Colour getColour(Side side) {
		return colour;
	}

}
