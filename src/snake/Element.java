package snake;

public class Element {

	public static enum TYPE {
		WALL, SNAKE, FOOD, EMPTY
	}

	public int x;
	public int y;
	public TYPE type;

	public Element(int _x, int _y, TYPE _t) {
		x = _x;
		y = _y;
		type = _t;
	}

	public int[] getXY() {
		return new int[] { x, y };
	}

	public void setXY(int[] a) {
		x = a[0];
		y = a[1];
	}

}
