package tada.suzu.shapedrawer;

public class ShapeDrawerImpl {

    public static void main(String... args) {

        ShapeDrawer japaneseRect = (w, d) -> "横は" + w + "cmで、縦は" + d + "cmです。";

        ShapeDrawer americanRect =
                (w,d)->String.format(
                        "Width: %.2f inches and Height: %.2f inches",
                        w,d);

        System.out.println(japaneseRect.drawShape(24.5, 39.7));
        System.out.println(americanRect.drawShape(americanRect.toInches(24.5), americanRect.toInches(39.7)));

    }
}
