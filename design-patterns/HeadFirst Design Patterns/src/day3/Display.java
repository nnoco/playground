package day3;

public class Display implements DisplayElement, Observer{
	private String name;

	public Display(String name) {
		this.name = name;
	}
	
	@Override
	public void update(float temp, float humidity, float pressure) {
		display(temp, humidity, pressure);
	}

	@Override
	public void display(float temp, float humidity, float pressure) {
		System.out.printf("updated %s : temp: %f / humidity: %f / pressure: %f\n", name, temp, humidity, pressure);
	}
}
