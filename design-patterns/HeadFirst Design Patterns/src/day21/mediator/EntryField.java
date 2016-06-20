package day21.mediator;

public class EntryField extends Widget{

	private String text;

	public EntryField(DialogDirector dialogDirector) {
		super(dialogDirector);
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	@Override
	public void handleMouse(MouseEvent event) {
		changed();
	}
	
}
