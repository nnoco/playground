package com.nnoco.playground.java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class LearningStream {
	public static void main(String[] args) {
		
		// 리듀싱
		int sum = IntStream.range(1, 101).reduce(0, (a, b) -> a + b);
		
		OptionalInt result = IntStream.range(1, 101).reduce((a, b) -> a + b);
		
		List<Dish> menu = MenuFactory.getMenu();
		
		int count = menu.stream()
			.map(d -> 1)
			.reduce(0, (a, b) -> a + b);
		
		System.out.println(count);
		
		System.out.println(sum);
	}

}

class MenuFactory {
	public static List<Dish> getMenu() {
		return Arrays.asList(
			new Dish("port", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER),
			new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH));
	}
}

class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}

	@Override
	public String toString() {
		return name;
	}

	public enum Type {
		MEAT, FISH, OTHER
	}
}
