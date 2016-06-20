package day19.operators;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorImplTest {
	@Test
	public void testSetters() {
		Color color = new ColorImpl(0);
		
		// set
		int red = 0xCA, green = 0xFE, blue = 0xBE;
		color.setRed(red);
		color.setGreen(green);
		color.setBlue(blue);
		
		System.out.println(toHex(color.getRed()));
		System.out.println(toHex(color.getGreen()));
		System.out.println(toHex(color.getBlue()));
		
		assertEquals(red, color.getRed());
		assertEquals(green, color.getGreen());
		assertEquals(blue, color.getBlue());
	}
	
	@Test
	public void testGetters() {
		Color color = new ColorImpl(0xFF1122);
		
		System.out.println(toHex(color.getRed()));
		System.out.println(toHex(color.getGreen()));
		System.out.println(toHex(color.getBlue()));
		
		assertEquals(0xFF, color.getRed());
		assertEquals(0x11, color.getGreen());
		assertEquals(0x22, color.getBlue());
	}
	
	String toHex(int value) {
		return String.format("0x%X", value);
	}
	
	@Test
	public void testValidation() {
		Color color = new ColorImpl(0);
		try {
			color.setRed(257);
		} catch (InvalidValueException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			color.setRed(-23);
		} catch (InvalidValueException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			color.setColor(0x1000000);
		} catch (InvalidValueException e) {
			System.err.println(e.getMessage());
		}
		
		try {
			color.setColor(-1);
		} catch (InvalidValueException e) {
			System.err.println(e.getMessage());
		}
	}

}
