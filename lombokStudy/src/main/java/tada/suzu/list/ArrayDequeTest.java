package tada.suzu.list;

import java.util.ArrayDeque;
import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayDequeTest {

	private static final int LEN = 10000000;

	public static void main(String[] args) {

		arrayDeque();

		arrayList();
		
	}

	private static void arrayList() {
		ArrayList<Integer> deque = new ArrayList<>();

		log.info("arrayList() setup start " + deque.size());

		for (int i = 0; i < LEN; i++) {
			deque.add(i);
		}
		log.info("arrayList() setup end " + deque.size());

		log.info("arrayList() start " + deque.size());

		for (int i = 0; i < LEN; i++) {
			int j = deque.get(i);
		}

		log.info("arrayList() end " + deque.size());
	}

	private static void arrayDeque() {
		ArrayDeque<Integer> deque = new ArrayDeque<>();

		log.info("arrayDeque() setup start " + deque.size());

		for (int i = 0; i < LEN; i++) {
			deque.add(i);
		}
		log.info("arrayDeque() setup end " + deque.size());

		
		log.info("arrayDeque() start " + deque.size());

		for (int i = 0; i < LEN; i++) {
			int j = deque.pop();
		}

		log.info("arrayDeque() end " + deque.size());
	}

}
