package com.axolotl.model;
import java.util.Random;

public enum Colour {
	RED,BLUE,YELLOW;
	
	public static Colour getRandomColour(){
		Random random = new Random();
		return values()[random.nextInt(values().length)];		
	}
}
