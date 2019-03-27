package tada.suzu.historypersonsort_methodref;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HistoryPersonSort {

    @FunctionalInterface
    interface Description {
        public String getString(HistoryPerson p);
    }

    public static void main(String... args) {

        読み仮名();
        System.out.println("-----------");
        居城の位置();
        System.out.println("-----------");
        生年();
    }

    public static void 読み仮名() {

        List<HistoryPerson> people = HistoryPerson.listPeople();
        Comparator<HistoryPerson> c = HistoryPersonCompareProvider::compareByName;

        Description d = HistoryPersonDescriber::describePerson;

        Collections.sort(people, c);
        for (HistoryPerson p : people) {
            System.out.println(d.getString(p));
        }

    }

    public static void 居城の位置() {

        List<HistoryPerson> people = HistoryPerson.listPeople();
        Comparator<HistoryPerson> c = HistoryPersonCompareProvider::compareByLatitude;

        Description d = HistoryPersonDescriber::describeCastle;

        Collections.sort(people, c);
        for (HistoryPerson p : people) {
            System.out.println(d.getString(p));
        }

    }

    public static void 生年() {

        List<HistoryPerson> people = HistoryPerson.listPeople();
        Comparator<HistoryPerson> c = HistoryPersonCompareProvider::compareByBornYear;

        HistoryPersonDescriber okhzmDescriber = new HistoryPersonDescriber(1560);

        Description d = okhzmDescriber::describeAge;

        Collections.sort(people, c);
        for (HistoryPerson p : people) {
            System.out.println(d.getString(p));
        }

    }

}
