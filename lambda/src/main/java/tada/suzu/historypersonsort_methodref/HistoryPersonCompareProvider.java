package tada.suzu.historypersonsort_methodref;

public class HistoryPersonCompareProvider {

    public static int compareByName(HistoryPerson p1, HistoryPerson p2) {
        return p1.getYomi().compareTo(p2.getYomi());
    }

    public static int compareByLatitude(HistoryPerson p1, HistoryPerson p2) {
        return Double.valueOf(p2.getCastleLatitude())
                .compareTo(Double.valueOf(p1.getCastleLatitude()));
    }

    public static int compareByBornYear(HistoryPerson p1, HistoryPerson p2) {
        return p1.getBornYear() - p2.getBornYear();
    }

}
