package tada.suzu.historypersonsort_methodref;

public class HistoryPersonDescriber {

    public static String describePerson(HistoryPerson p) {
        return p.getName() + " " + p.getBornYear() + "-" + p.getDeadYear();
    }

    public static String describeCastle(HistoryPerson p) {
        return p.getName() + "が居城とした" + p.getCastleName();
    }

    public int compareYear;

    public HistoryPersonDescriber(int year) {
        this.compareYear = year;
    }

    public String describeAge(HistoryPerson p) {
        String description = p.getName() + "は";

        if (this.compareYear < p.getBornYear()) {
            description += "まだ生まれていませんでした";
        } else if (this.compareYear > p.getDeadYear()) {
            description += "もうこの世にいませんでした";
        } else {
            description += this.compareYear - p.getBornYear() + "歳でした";
        }

        return description;
    }


}
