package tada.suzu.historypersonsort;

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
        Comparator<HistoryPerson> c = (p1, p2) -> p1.getYomi().compareTo(p2.getYomi());

        Description d = (p) -> p.describePerson();

        Collections.sort(people, c);
        for(HistoryPerson p : people) {
            System.out.println(d.getString(p));
        }

    }

    public static void 居城の位置() {

        List<HistoryPerson> people = HistoryPerson.listPeople();
//        Comparator<HistoryPerson> c = (p1, p2) -> new Double(p2.getCastleLatitude()).compareTo(new Double(p1.getCastleLatitude()));
        Comparator<HistoryPerson> c = (p1, p2) -> Double.valueOf(p2.getCastleLatitude()).compareTo(Double.valueOf(p1.getCastleLatitude()));
//        Comparator<HistoryPerson> c = (p1, p2) -> p2.getCastleLatitude().compareTo(p1.getCastleLatitude());

        Description d = (p) -> p.describeCastle();

        Collections.sort(people, c);
        for(HistoryPerson p : people) {
            System.out.println(d.getString(p));
        }

    }

    public static void 生年() {

        List<HistoryPerson> people = HistoryPerson.listPeople();
        Comparator<HistoryPerson> c = (p1, p2) -> p1.getBornYear() - p2.getBornYear();

        Description d = (p) -> p.describeAge(1560);

        Collections.sort(people, c);
        for(HistoryPerson p : people) {
            System.out.println(d.getString(p));
        }

    }

}
