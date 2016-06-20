package day19.operators;

public interface Color {
	public int getRed();
	public int getGreen();
	public int getBlue();
	public int getColor();
	
	public void setRed(int red);
	public void setGreen(int green);
	public void setBlue(int blue);
	
	public void setColor(int color);
	public void setColor(int red, int green, int blue);
}
