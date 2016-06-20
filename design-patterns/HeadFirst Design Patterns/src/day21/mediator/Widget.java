package day21.mediator;

public abstract class Widget {
	private DialogDirector dialogDirector;

	public Widget(DialogDirector dialogDirector) {
		this.dialogDirector = dialogDirector;
	}
	
	public void changed() {
		dialogDirector.widgetChanged(this);
	}
	
	public abstract void handleMouse(MouseEvent event);
}
