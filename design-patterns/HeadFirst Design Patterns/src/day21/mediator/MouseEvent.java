package day21.mediator;

import java.awt.Point;

public class MouseEvent {
	public static enum EventType {
		Click
	};
	private Point point;
	private EventType eventType;
	
	
	public MouseEvent(EventType eventType, int x, int y) {
		this.point = new Point(x, y);
	}
	
	public Point getPoint() {
		return point;
	}
	
	public EventType getEventType() {
		return eventType;
	}
}
