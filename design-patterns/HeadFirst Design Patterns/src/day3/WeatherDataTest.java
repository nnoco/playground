package day3;

public class WeatherDataTest {
	public static void main(String[] args) {
		WeatherData weatherData = new WeatherData();
		
		weatherData.registerObserver(new Display("Current Condition Display"));
		weatherData.registerObserver(new Display("Statistics Display"));
		weatherData.registerObserver(new Display("Forecast Display"));
		
		for(int i = 0; i < 10; i++) {
			weatherData.measurementsChanged();
			System.out.println();
		}
	}
}
