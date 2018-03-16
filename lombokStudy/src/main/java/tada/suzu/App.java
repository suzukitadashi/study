package tada.suzu;

import java.util.Arrays;
import java.util.HashMap;

import lombok.val;
import lombok.extern.slf4j.Slf4j;
import tada.suzu.work.Work;

/**
 * Hello world!
 *
 */
@Slf4j
public class App {
	public static void main(String[] args) {
		log.info("Hello World!");

		TestObject obj1 = new TestObject();
		obj1.setId(1);
		obj1.setName("Suzuki");

		TestObject obj2 = new TestObject(10, "Tanaka");

		TestBuilderObject builderObject = TestBuilderObject.builder().id(2).name("Yamada").build();

		log.info(obj1.toString());
		log.info(obj2.toString());
		log.info(builderObject.toString());

		log.info("-----");

		val list = Arrays.asList("hoge", "fuga", "piyo");
		list.forEach(log::debug);

		log.info("-----");

		val map = new HashMap<String, Long>();
		map.put("hoge", 1L);
		log.info(map.get("hoge").toString());

		Work.print();

	}
}
