package day21.mediator;

import java.awt.Point;
import java.util.List;

public class ListBox extends Widget{
	private List<String> listItems;
	private int selectedIndex;

	public ListBox(DialogDirector dialogDirector) {
		super(dialogDirector);
	}
	
	public String getSelection() {
		return listItems.get(selectedIndex);
	}
	
	public void setList(List<String> listItems) {
		this.listItems = listItems;
	}
	
	@Override
	public void handleMouse(MouseEvent event) {
		Point point = event.getPoint();
		if (0 < point.getX() && point.getX() < 100) {
			int y = (int)point.getY() / 100;
			if(y < listItems.size()) {
				setSelection(y);
				changed();
			}
		}
	}

	private void setSelection(int y) {
		selectedIndex = y;
	}

}
