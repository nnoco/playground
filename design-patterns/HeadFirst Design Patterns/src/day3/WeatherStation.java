package day3;

import java.util.Random;

public class WeatherStation {
	private Random random = new Random(System.currentTimeMillis());
	
	private float temp;
	private float humidity;
	private float pressure;
	
	public WeatherStation() {
		temp = random.nextFloat() * 100;
		humidity = random.nextFloat();
		pressure = random.nextFloat() * 1000;
	}
	
	public float getTemperature() {
		return temp + ((random.nextFloat() * 10) - 5);
	}
	
	public float getHumidity() {
		return humidity + (random.nextFloat() - 1);
	}
	
	public float getPressure() {
		return pressure + ((random.nextFloat() * 100) - 50);
	}
}
