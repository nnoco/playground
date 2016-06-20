package day22.state;

public class GumballMachine implements State {
	State soldState;
	State soldOutState;
	State noQuarterState;
	State hasQuarterState;
	State state;
	
	int count = 0;
	
	public GumballMachine(int count) {
		soldOutState = new SoldOutState(this);
		soldState = new SoldState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this); 
		this.count = count;
		if (count > 0) {
			state = noQuarterState;
		}
	}
	
	public void insertQuarter() {
		state.insertQuarter();
	}

	@Override
	public void ejectQuarter() {
		state.ejectQuarter();
	}

	@Override
	public void turnCrank() {
		state.turnCrank();
	}

	@Override
	public void dispense() {
		state.dispense();
	}
	
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (count != 0) {
			count = count - 1;
		}
	}

	public State getSoldState() {
		return soldState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public int getCount() {
		return count;
	}
}
