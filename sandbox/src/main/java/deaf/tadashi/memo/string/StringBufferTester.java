package deaf.tadashi.memo.string;

public class StringBufferTester implements RunnableEx {
	// スレッドセーフなクラス
	private StringBuffer sb = new StringBuffer();

	@Override
	public void run() {
		for (int i=0; i<100; i++) {
			sb.append('#');
		}
	}
	public int length() {
		return sb.length();
	}
}
