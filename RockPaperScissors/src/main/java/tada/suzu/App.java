package tada.suzu;

import java.util.Random;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Hello world!
 *
 */
@Slf4j
public class App {

	public static void main(String[] args) {
		new App().execute();
	}

	private static final String ログメッセージ = "{}回目 出した手 A：{}, B:{}, {}";
	private static final String エラーログメッセージ = "出した手 A：{}, B:{}, {}";

	private void execute() {

		Random rand = new Random();

		結果 kekka = new 結果();

		for (int i = 0; i < 100; i++) {

			じゃんけんの型 Aが出した手 = じゃんけんの型.型を求める(rand.nextInt(3));
			じゃんけんの型 Bが出した手 = じゃんけんの型.型を求める(rand.nextInt(3));

			じゃんけんの結果 結果 = judge(Aが出した手, Bが出した手);
			if (結果 == じゃんけんの結果.Aの勝ち) {
				kekka.addAの勝ち();
				log.info(ログメッセージ, (i + 1), Aが出した手.name(), Bが出した手.name(), "Aの勝ち");
			} else if (結果 == じゃんけんの結果.Bの勝ち) {
				kekka.addBの勝ち();
				log.info(ログメッセージ, (i + 1), Aが出した手.name(), Bが出した手.name(), "Bの勝ち");
			} else if (結果 == じゃんけんの結果.あいこ) {
				kekka.addあいこ();
				log.info(ログメッセージ, (i + 1), Aが出した手.name(), Bが出した手.name(), "あいこ");
			}

		}

		log.info("通算");
		log.info("あいこの数:" + kekka.getあいこ());
		log.info("Aの勝ち数:" + kekka.getAの勝ち());
		log.info("Bの勝ち数:" + kekka.getBの勝ち());

	}

	@Data
	private final class 結果 {

		private int あいこ = 0;
		private int Aの勝ち = 0;
		private int Bの勝ち = 0;

		synchronized void addAの勝ち() {
			this.Aの勝ち++;
		}

		synchronized void addBの勝ち() {
			this.Bの勝ち++;
		}

		synchronized void addあいこ() {
			this.あいこ++;
		}
	}

	private じゃんけんの結果 judge(じゃんけんの型 Aが出した手, じゃんけんの型 Bが出した手) {

		if (Aが出した手 == Bが出した手) {
			return じゃんけんの結果.あいこ;
		}

		switch (Aが出した手) {
		case グー:
			if (Bが出した手 == じゃんけんの型.パー) {
				return じゃんけんの結果.Bの勝ち;
			} else {
				return じゃんけんの結果.Aの勝ち;
			}
		case パー:
			if (Bが出した手 == じゃんけんの型.チョキ) {
				return じゃんけんの結果.Bの勝ち;
			} else {
				return じゃんけんの結果.Aの勝ち;
			}
		case チョキ:
			if (Bが出した手 == じゃんけんの型.グー) {
				return じゃんけんの結果.Bの勝ち;
			} else {
				return じゃんけんの結果.Aの勝ち;
			}
		default:
			log.error(エラーログメッセージ, Aが出した手.name(), Aが出した手.name(), "想定外の手");
			throw new IllegalArgumentException();
		}

	}

	enum じゃんけんの型 {

		グー(0), チョキ(1), パー(2);

		@Getter
		private final int id;

		private じゃんけんの型(int id) {
			this.id = id;
		}

		public static じゃんけんの型 型を求める(int id) {

			for (じゃんけんの型 kata : じゃんけんの型.values()) {
				if (kata.getId() == id) {
					return kata;
				}
			}

			throw new IllegalArgumentException();

		}
	}

	enum じゃんけんの結果 {
		Aの勝ち, Bの勝ち, あいこ
	}

}
