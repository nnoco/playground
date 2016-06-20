package day9;

public class SimpleRemoteControl {
	private Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void buttonWasPressed() {
		command.execute();
	}
}
