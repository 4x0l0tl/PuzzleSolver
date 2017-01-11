package com.axolotl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import com.axolotl.model.Board;
import com.axolotl.model.Colour;
import com.axolotl.model.Piece;
import com.axolotl.model.SidePiece;

public class Reader {

	private static final String prefix = System.getProperty("user.dir") + File.separator + "puzzles" + File.separator;
	private static final String PiecesPath = prefix + "pieces.txt";
	private static final String BoardPath = prefix + "board.txt";

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader(PiecesPath))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Queue<Piece> readPieces(){
		Queue<Piece> pieces = new LinkedList<Piece>();
		try (BufferedReader br = new BufferedReader(new FileReader(PiecesPath))) {
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				Piece piece = new Piece();
				String [] sideColour = sCurrentLine.split(",");
				for(int i=0; i<4; i++) {
					piece.addColour(Colour.valueOf(sideColour[i]));
				}
				pieces.add(piece);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pieces;
	}
	public static Board readBoard() {
		SidePiece [] sides = new SidePiece[16];
		try (BufferedReader br = new BufferedReader(new FileReader(BoardPath))) {
			String [] sideColours = br.readLine().split(",");
			for(int i=0;i<16;i++) {
				sides[i] = new SidePiece(Colour.valueOf(sideColours[i]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new Board(sides);
	}
}