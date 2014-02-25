package biz.no_ip.druidamortis.Labs;


/**
 *
 * @author Michael Walter
 */
public class Dreieck {

    /**
     * Berechnet den der Seite s1 gegenüberliegenden Winkel
     * @param s1 seitenlänge 1
     * @param s2 seitenlänge 2
     * @param s3 seitenlänge 3
     * @return Winkel der der Seite s1 gegenüberliegt
     */
    public static double sss(double s1, double s2, double s3) {
        if (s1 <= 0 || s2 <= 0 || s3 <= 0) {
            return Double.NaN;
        }

        if (s1 > s2 && s1 > s3 && s2 + s3 < s1) {
            if (s2 + s3 <= s1) {
                return Double.NaN;
            }
        }
        if (s2 > s1 && s2 > s3) {
            if (s1 + s3 <= s2) {
                return Double.NaN;
            }
        }
        if (s3 > s1 && s3 > s2) {
            if (s1 + s2 <= s3) {
                return Double.NaN;
            }
        }
        return Math.toDegrees(Math.acos((s3 * s3 + s2 * s2 - s1 * s1) / (2 * s3 * s2)));
    }

    /**
     * Berechnet den der Seite s2 gegenüberliegenden Winkel
     * @param s1 seitenlänge 1
     * @param s2 seitenlänge 2
     * @param w1 der der Seite s1 gegenüberliegende Winkel
     * @return vierparametrige Funktion aufrufen
     */
    public static double ssw(double s1, double s2, double w1) {
        return ssw(s1, s2, w1, false);
    }

    /**
     * Berechnet den der Seite s2 gegenüberliegenden Winkel
     * @param s1 seite 1
     * @param s2 seite 2
     * @param w1 der der Seite s1 gegenüberliegende Winkel
     * @param big bei zwei möglichen Gegenwinkeln den größeren zurückgeben
     * @return Winkel der der Seite s2 gegenüberliegt
     */
    public static double ssw(double s1, double s2, double w1, boolean big) {
        if (s1 <= 0 || s2 <= 0 || w1 <= 0 || w1 >= 180) {
            return Double.NaN;
        }

        double ret = Math.toDegrees(Math.asin((Math.sin(Math.toRadians(w1)) * s2) / s1));

        if (big) {
            ret = 180 - ret;
        }
        if (Math.round(ret) == 90 && w1 == 45) {
            return 90;
        }
        return ret;
    }

    /**
     * berechnet die Seite die dem Winkel w gegenüber liegt
     * @param s1 Seite 1
     * @param w zwischen s1 und s3 liegender Winkel
     * @param s3 Seite 3
     * @return Länge der Seite die dem Winkel w gegenüberliegt
     */
    public static double sws(double s1, double w, double s3) {
        if (s1 <= 0 || s3 <= 0 || w <= 0 || w >= 180) {
            return Double.NaN;
        }

        return Math.sqrt(s3 * s3 + s1 * s1 - 2 * s1 * s3 * Math.cos(Math.toRadians(w)));
    }

    /**
     * berechnet die Seite die w2 gegenüberliegt
     * @param s seitenlänge
     * @param w1 Winkel der s gegenüberliegt
     * @param w2 Winkel zwischen w1 und s
     * @return Länge der Seite die w2 gegenüberliegt
     */
    public static double sww(double s, double w1, double w2) {
        if (s <= 0 || w1 <= 0 || w2 <= 0 || w1 + w2 >= 180) {
            return Double.NaN;
        }
        return (Math.sin(Math.toRadians(w2)) * s) / Math.sin(Math.toRadians(w1));
    }

    /**
     * Berechnet mit Hilfe der an die Seite s anliegenden Winkeln die Seite die dem Winkel w1 gegenüberliegt
     * @param w1 Winkel der an s anliegt
     * @param s Seitenlänge
     * @param w2 anderer Winkel der an s anliegt
     * @return Länge der Seite die w1 gegenüberliegt
     */
    public static double wsw(double w1, double s, double w2) {
        if (w1 <= 0 || s <= 0 || w2 <= 0 || w1 + w2 >= 180) {
            return Double.NaN;
        }

        return (s * Math.sin(Math.toRadians(w1)) / Math.sin(Math.toRadians(180 - w1 - w2)));
    }

    /**
     * Berechnet mit Hilfe der drei Seiten und der Heron'schen Formel den Flächeninhalt
     * @param s1 Seitenlänge 1
     * @param s2 Seitenlänge 2
     * @param s3 Seitenlänge 3
     * @return Flächeninhalt
     */
    public static double flaeche(double s1, double s2, double s3) {
        if (s1 <= 0 || s2 <= 0 || s3 <= 0) {
            return Double.NaN;
        }

        return 0.25 * Math.sqrt((s2 + s3 + s1) * (-s2 + s3 + s1) * (s2 - s3 + s1) * (s2 + s3 - s1));
    }

    public static double flaeche2(double s1, double w, double s3) {
        if (s1 <= 0 || s3 <= 0 || w <= 0 || w >= 180) {
            return Double.NaN;
        }

        return s3 * s1 * Math.sin(Math.toRadians(w)) / 2;
    }

    /**
     * Berechnet mit Hilfe einer Seite und der darauf liegenden Höhe den Flächeninhalt
     * @param s Seite
     * @param h Höhe auf der Seite s
     * @return Flächeninhalt
     */
    public static double flaeche(double s, double h) {
        if (s <= 0 || h <= 0) {
            return Double.NaN;
        }
        return (s * h) / 2;
    }

    /**
     * Berechnet mit Hilfe der Fläche und einer Seite die darauf liegende Höhe
     * @param s Seite deren Höhe berechnet werden soll
     * @param f Flächeninhalt
     * @return auf der Seite s stehende Höhe
     */
    public static double hoehe(double s, double f) {
        if (s <= 0 || f <= 0) {
            return Double.NaN;
        }
        return (2 * f) / s;
    }

    /**
     * Berechnet mit Hilfe von zwei Seiten und dem dazwischenliegenden Winkel die Höhe auf s1
     * @param s1 Seitenlänge 1
     * @param w zwischen s1 und s3 liegender Winkel
     * @param s3 Seitenlänge 3
     * @return auf der Seite s1 stehende Höhe
     */
    public static double hoehe(double s1, double w, double s3) {
        if (s1 <= 0 || s3 <= 0 || w <= 0 || w >= 180) {
            return Double.NaN;
        }

        double s2 = sws(s1, w, s3);

        return 2 * flaeche(s1, s2, s3) / s1;
    }
}
