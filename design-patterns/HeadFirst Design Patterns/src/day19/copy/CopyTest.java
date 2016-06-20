package day19.copy;

import java.util.Arrays;

public class CopyTest {
	public static void main(String[] args) {
		Value[] values = {new Value(1), new Value(5)};
		
		Value[] newValues = Arrays.copyOf(values, values.length);
		
		values[0].i = 113;
		
		System.out.println(newValues[0].i);
	}
}

class Reference {
	Value v;
	
	public static Reference shallowCopy(Reference r) {
		Reference newR = new Reference();
		newR.v = r.v;
		
		return newR;
	}
	
	public static Reference deepCopy(Reference r) {
		Reference newR = new Reference();
		newR.v = new Value(r.v.i);
		
		return null;
	}
}

class Value {
	int i = 0;
	
	public Value(int i) {
		this.i = i;
	}
}
