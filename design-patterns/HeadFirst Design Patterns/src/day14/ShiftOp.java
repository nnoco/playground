package day14;

public class ShiftOp {
	// 10100011 4byte 
	// >> 11010001
	public static void main(String[] args) {
		for (int i = 23 ; i > 0 ; i >>>=1) {
			System.out.println(i);
		}
	}
}
