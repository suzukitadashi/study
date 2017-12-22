package deaf.tadashi.memo.string;

public class StringBuilderTester implements RunnableEx {
	// スレッドセーフでないクラス
	private StringBuilder sb = new StringBuilder();

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