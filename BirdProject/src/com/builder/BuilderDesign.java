package com.builder;

class Burger{
	
	String bunName;
	
	String patty;
	
	boolean sose;
	
	boolean mionus;
	
	
	public Burger setBunName(String bunName) {
		this.bunName = bunName;
		return this;
	}
	public Burger setPatty(String patty) {
		this.patty = patty;
		return this;
	}
	public Burger setSose(boolean sose) {
		this.sose = sose;
		return this;
	}
	public Burger setmionus(boolean mionus) {
		this.mionus = mionus;
		return this;
	}
	@Override
	public String toString() {
		return "Burger [bunName=" + bunName + ", patty=" + patty + ", sose=" + sose + ", mionus=" + mionus + "]";
	}
	
	
}



public class BuilderDesign {

	public static void main(String[] args) {
		
		// Build a Burger
		 Burger b1 = new Burger().setBunName("Double Bun").setPatty("Double Patty").setSose(true).setmionus(true);
		 System.out.println(b1);
		  
		 Burger b2 =new Burger().setBunName("Sing Bun").setPatty("Single Patty").setSose(false).setmionus(true);
		 System.out.println(b2);
		 

	}

}
