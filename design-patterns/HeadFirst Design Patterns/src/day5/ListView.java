package day5;

public class ListView {
	BaseAdapter adapter;

	public ListView(BaseAdapter adapter) {
		this.adapter = adapter;
	}
	
	public void display(int index) {
		View view = adapter.getView(this, index);
		view.Display();
	}
}
