package day21.mediator;

public class Button extends Widget{

	private String text;

	public Button(DialogDirector dialogDirector) {
		super(dialogDirector);
	}
	
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void handleMouse(MouseEvent event) {
		changed();
	}

}
