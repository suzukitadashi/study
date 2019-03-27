package tada.suzu.historypersonsort_methodref;

import java.util.ArrayList;
import java.util.List;

public class HistoryPerson {

    private Name name;
    private Life life;
    private Castle castle;

    public HistoryPerson() {
        this.name = new HistoryPerson.Name();
        this.life = new HistoryPerson.Life();
        this.castle = new HistoryPerson.Castle();
    }

    HistoryPerson createName(String kanji, String yomi) {
        this.name.create(kanji, yomi);
        return this;
    }

    HistoryPerson createLife(int bornYear, int deadYear) {
        this.life.create(bornYear, deadYear);
        return this;
    }

    HistoryPerson createCastile(String name, double latitude, double longitude) {
        this.castle.create(name, latitude, longitude);
        return this;
    }

    class Name {
        private String kanji = "";
        private String yomi = "";

        void create(String kanji, String yomi) {
            this.kanji = kanji;
            this.yomi = yomi;
        }
    }

    class Life {
        private int bornYear = 0;
        private int deadYear = 0;

        void create(int bornYear, int deadYear) {
            this.bornYear = bornYear;
            this.deadYear = deadYear;
        }
    }

    class Castle {
        private String name = "";
        private double latitude = 0;
        private double longitude = 0;

        void create(String name, double latitude, double longitude) {
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }

    public String getName() {
        return this.name.kanji;
    }

    public String getYomi() {
        return this.name.yomi;
    }

    public int getBornYear() {
        return this.life.bornYear;
    }

    public int getDeadYear() {
        return this.life.deadYear;
    }

    public String getCastleName() {
        return this.castle.name;
    }

    public double getCastleLatitude() {
        return this.castle.latitude;
    }

    public double getCastleLongitude() {
        return this.castle.longitude;
    }

    public static List<HistoryPerson> listPeople() {

        List<HistoryPerson> people = new ArrayList<>();

        people.add(new HistoryPerson().createName("武田信玄", "たけだしんげん")
                .createLife(1521, 1573)
                .createCastile("躑躅ヶ崎館", 35.414171, 138.343890));

        people.add(new HistoryPerson().createName("上杉謙信", "うえすぎけんしん")
                .createLife(1530, 1578)
                .createCastile("春日山城", 37.084808, 138.121999));

        people.add(new HistoryPerson().createName("織田信長", "おだのぶなが")
                .createLife(1534, 1582)
                .createCastile("安土城", 35.092129, 136.082487));

        people.add(new HistoryPerson().createName("伊達政宗", "だてまさむね")
                .createLife(1567, 1638)
                .createCastile("青葉城", 38.150892, 140.512216));

        people.add(new HistoryPerson().createName("北条氏康", "ほうじょううじやす")
                .createLife(1515, 1571)
                .createCastile("小田原城", 35.150377, 139.091239));

        people.add(new HistoryPerson().createName("毛利元就", "もうりもとなり")
                .createLife(1521, 1573)
                .createCastile("吉田郡山城", 34.402747, 132.423452
                ));

        return people;
    }

}


