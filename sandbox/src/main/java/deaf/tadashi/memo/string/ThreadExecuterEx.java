package deaf.tadashi.memo.string;

public class ThreadExecuterEx {

private static final int THREAD_MAX = 100;
	
	public static void main(String[] args) throws InterruptedException {

//		test(new StringBufferTester());
		test(new StringBuilderTester());
//		test(new StringBuilderTesterEx());
		
	}
	
	
	private static void test(RunnableEx tester) throws InterruptedException {

		String className = tester.getClass().getName();
		
		Thread[] ts = new Thread[THREAD_MAX];
		// スレッド初期化
		for (int i=0; i<THREAD_MAX; i++) {
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
		System.out.println(className + " Result:" + tester.length());

		
	}
	

	
}
