package tada.suzu.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

	public static void main(String[] args) {

		log.info("LinkedList start");
		List<Integer> list1 = createLinkedList();
		put(list1);
		rejectMultipleOf3(list1);
		log.info("LinkedList end");
		
		log.info("ArrayList start");
		List<Integer> list2 = createArrayList();
		put(list2);
		rejectMultipleOf3(list2);
		log.info("ArrayList end");
		
		
	}
	
	// 3で割り切れる数を排除する
	public static void rejectMultipleOf3(List<Integer> list) {
	    for(Iterator<Integer> iter = list.iterator(); iter.hasNext(); ) {
	        int i = iter.next();
	        if(i % 3 == 0){
	            iter.remove();
	        }
	    }
	}

	public static List<Integer> createLinkedList() {
		
		List<Integer> list = new LinkedList<>();
		
		return list;
		
	}

	public static List<Integer> createArrayList() {
		
		List<Integer> list = new ArrayList<>();
		
		return list;
		
	}
	
	public static void put(List<Integer> list) {
		
		for(int i = 0; i < 1000000; i++) {
			list.add(i);
		}
		
	}

}
