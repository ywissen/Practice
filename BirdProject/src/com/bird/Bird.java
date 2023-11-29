package com.bird;

interface Bird {

	default int numberOfLegs() {
		return 2;
	}
	
	String color();
	boolean birdCanFly();
}
