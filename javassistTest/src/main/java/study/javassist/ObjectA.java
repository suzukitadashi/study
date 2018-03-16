package study.javassist;

public class ObjectA {

	private int f = 17;
	String s1 = "o_o!";
	int x = 100;
	int y = 300;

	public void m(int a) {
		x += a;
		y += a;

	}

	public String toString() {
		return " x:" + x + " y:" + y;
	}

}
