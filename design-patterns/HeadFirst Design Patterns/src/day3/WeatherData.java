package day3;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
	private WeatherStation station = new WeatherStation();
	private List<Observer> observers = new ArrayList<Observer>();
	
	public float getTemperature() {
		return station.getTemperature();
	}
	
	public float getHumidity() {
		return station.getHumidity();
	}
	
	public float getPressure() {
		return station.getHumidity();
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		float temp = getTemperature();
		float humidity = getHumidity();
		float pressure = getPressure();
		
		for(Observer observer : observers) {
			observer.update(temp, humidity, pressure);
		}
	}
}
