package deaf.tadashi.memo.string;

public class StringBuilderTesterEx implements RunnableEx {

	volatile private StringBuilder sb = new StringBuilder();

	@Override
	public void run() {

		synchronized (this) {

			for (int i = 0; i < 100; i++) {
				sb.append('#');
			}
		}
	}

	public int length() {
		return sb.length();
	}
}