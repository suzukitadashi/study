package deaf.tadashi.memo.string;

public class ThreadExecuter {

	private static final int THREAD_MAX = 100;

	public static void main(String[] args) throws InterruptedException {
		StringBuilderTester tester = new StringBuilderTester();
//		StringBufferTester tester = new StringBufferTester();
		Thread[] ts = new Thread[THREAD_MAX];
		// スレッド初期化
		for (int i = 0; i < THREAD_MAX; i++) {
			ts[i] = new Thread(tester);
		}
		// スレッド開始
		for (Thread t : ts) {
			t.start();
		}
		// スレッド同期
		for (Thread t : ts) {
			t.join();
		}
		System.out.println("Result:" + tester.length());
	}

}
