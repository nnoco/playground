package day9;

public class GarageDoorOpenCommand implements Command{
	
	private GarageDoor garageDoor;

	public GarageDoorOpenCommand(GarageDoor garageDoor) {
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.openDoor();
		
	}

}
