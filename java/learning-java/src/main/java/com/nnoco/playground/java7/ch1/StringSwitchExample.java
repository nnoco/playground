package com.nnoco.playground.java7.ch1;

/**
 * 스트링으로 값 분기
 * - switch 문에서 사용할 스트링 타입 변수 생성
 * - case 구문에서 스트링 리터럴을 사용하는 switch 구문을 작성한다.
 * - 1단계에서 생성한 스트링 변수를 switch문을 제어
 * 
 * @author nnoco
 *
 */
public class StringSwitchExample {
	private static boolean verbose = false;
	private static boolean logging = false;
	private static boolean displayHelp = false;
	
	public static void main(String[] args) {
		for(String argument : args) {
			switch(argument) {
			case "-verbose":
			case "-v":
				verbose = true;
			break;
			case "-log":
				logging=true;
				break;
			case "help":
				displayHelp = true;
				break;
			default:
				System.out.println("Illegal command line argument");	
			}
		}
		
		displayApplicationSettings();
	}
	
	private static void displayApplicationSettings() {
		System.out.println("Application Settings");
		System.out.println("Verbose: " + verbose);
		System.out.println("Logging: " + logging);
		System.out.println("Help: " + displayHelp);
	}
}
