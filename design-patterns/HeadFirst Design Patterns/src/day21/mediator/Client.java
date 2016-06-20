package day21.mediator;

import day21.mediator.MouseEvent.EventType;

public class Client {
	public static void main(String[] args) {
		FontDialogDirector director = new FontDialogDirector();
		director.createWidgets();

		
		ListBox fontList = director.getFontList();
		fontList.handleMouse(new MouseEvent(EventType.Click, 10, 20));
		fontList.handleMouse(new MouseEvent(EventType.Click, 10, 120));
		fontList.handleMouse(new MouseEvent(EventType.Click, 10, 220));
		
		director.getOk().handleMouse(new MouseEvent(EventType.Click, 10, 20));
	}
}
