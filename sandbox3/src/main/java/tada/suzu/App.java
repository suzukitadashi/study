package tada.suzu;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Hello world!
 *
 */
public class App {

	private static final int LTS_CYCLE = 3;

	public static void main(String[] args) {

		var javaVersion = 11;
		var ltsRelease = LocalDate.of(2018, 9, 1);
		var ld = LocalDate.of(2019, 2, 1);
		var f = DateTimeFormatter.ofPattern("yyyy/MM");

		while (true) {
			if (javaVersion == 110) {
				break;
			}

			ld = ld.plusMonths(1);
			if (isNewVersionRelease(ld)) {
				javaVersion++;

				String msg = ld.format(f) + "の時点のJavaのバージョンは" + javaVersion + "です。";
				if (isLtsVersionRelease(ltsRelease, ld)) {
					ltsRelease = ld;
					msg += "LTSの対象です。";
					System.out.println(msg);
				}

//				System.out.println(msg);

			}

		}

	}

	private static boolean isNewVersionRelease(LocalDate nowDate) {
		return nowDate.getMonth() == Month.MARCH || nowDate.getMonth() == Month.SEPTEMBER;
	}

	private static boolean isLtsVersionRelease(LocalDate ltsDate, LocalDate nowDate) {

		long diffYear = ChronoUnit.YEARS.between(ltsDate, nowDate);
		return (diffYear == LTS_CYCLE);

	}

}
