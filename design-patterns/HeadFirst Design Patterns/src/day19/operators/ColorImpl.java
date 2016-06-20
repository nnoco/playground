package day19.operators;

public class ColorImpl implements Color{
	private static int MASK_RED = 0xFF0000;
	private static int MASK_GREEN = 0x00FF00;
	private static int MASK_BLUE = 0x0000FF;
	private static int MASK_RGB_COLOR_RANGE = 0x00FFFFFF;
	private static int SHIFT_COUNT_RED = 16;
	private static int SHIFT_COUNT_GREEN = 8;
	private static int SHIFT_COUNT_BLUE = 0;
	
	private int color;
	
	public ColorImpl(int red, int green, int blue) {
		setColor(red, green, blue);
	}
	
	public ColorImpl(int color) {
		setColor(color);
	}

	@Override
	public void setRed(int red) {
		clear(MASK_RED);
		set(red, SHIFT_COUNT_RED, MASK_RED);
		
	}
	
	@Override
	public void setGreen(int green) {
		clear(MASK_GREEN);
		set(green, SHIFT_COUNT_GREEN, MASK_GREEN);
	}
	
	@Override
	public void setBlue(int blue) {
		clear(MASK_BLUE);
		set(blue, SHIFT_COUNT_BLUE, MASK_BLUE);
	}
	
	@Override
	public void setColor(int color) {
		checkColorValidation(color);
		// int의 제일 앞 8비트는 잘라내도록 함
		this.color = color & MASK_RGB_COLOR_RANGE;
	}
	
	@Override
	public void setColor(int red, int green, int blue) {
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}
	
	@Override
	public int getRed() {
		return get(SHIFT_COUNT_RED, MASK_RED);
	}
	
	@Override
	public int getGreen() {
		return get(SHIFT_COUNT_GREEN, MASK_GREEN);
	}
	
	@Override
	public int getBlue() {
		return get(SHIFT_COUNT_BLUE, MASK_BLUE);
	}
	
	@Override
	public int getColor() {
		return color;
	}
	
	private void clear(int mask) {
		color &= ~mask;
	}
	
	private void set(int code, int countOfShift, int mask) {
		checkCodeValidation(code);
		color |= (code << countOfShift) & mask;
	}
	
	private int get(int countOfShift, int mask) {
		return (color & mask) >> countOfShift;
	}
	
	/**
	 * 색상 코드값이 유효한지 확인한다. 색상 값은 음수가 될 수 없으며, 최대 0xFF가 될 수 있다.
	 * @throws InvalidValueException
	 * @param code 확인할 색상값
	 */
	private void checkCodeValidation(int code) {
		checkValidation(code, 0, 0xFF);
	}
	
	/**
	 * 색상 값이 유효한지 확인한다. 색상 값은 음수가 될 수 없으며, 최대 0xFFFFFF 가 될 수 있다.
	 * @throws InvalidValueException
	 * @param color 확인할 색상값
	 */
	private void checkColorValidation(int color) {
		checkValidation(color, 0, 0xFFFFFF);
		// 음수인 경우 혹은 0x00FFFFFF보다 큰 경우
		if (color < 0 || color > 0xFFFFFF) {
			throw new InvalidValueException("색상 값은 0에서 0xFFFFFF입니다. 올바른 색상값을 입력해 주십시오. code : " + color);
		}
	}
	
	private void checkValidation(int value, int min, int max) {
		if (value < min || value > max) {
			throw new InvalidValueException(String.format("색상 값은 0x%X에서 0x%X입니다. 올바른 색상 값을 입력해 주십시오. value: 0x%X", min, max, value));
		}
	}
	
}
