package com.example.presentation;


public class ControllerUtils {

    public static final int MIN_BODIES_NUM = 1;
    public static final int MAX_BODIES_NUM = 1024;
    public static final int DEFAULT_BODIES_NUM = 4;

    public static final int MIN_DELTA_TIME = 16;
    public static final int MAX_DELTA_TIME = 128;
    public static final int DEFAULT_DELTA_TIME = MIN_DELTA_TIME;

    public static final double MIN_ERROR_DISTANCE = 1e2;
    public static final double MAX_ERROR_DISTANCE = 1e3;
    public static final double DEFAULT_ERROR_DISTANCE = MIN_ERROR_DISTANCE;
    public static double distance(Dot d1, Dot d2) {
        var p1 = d1.getP();
        var p2 = d2.getP();
        return Math.sqrt(
                Math.pow(p1.x() - p2.x(), 2) + Math.pow(p1.y() - p2.y(), 2)
        );
    }

    public static double magnitude(Dot d1, Dot d2, double b1b2distance) {
        return Dots.G * d1.getM() * d2.getM() / Math.pow(b1b2distance, 2);
    }

    public static Dot.Coords direction(Dot d1, Dot d2) {
        return new Dot.Coords(
                d2.getP().x()- d1.getP().x(),
                d2.getP().y() - d1.getP().y());
    }

    public static Dot.Coords dv(Dot b, long dt) {
        return new Dot.Coords(
                b.getF().x() / b.getM() * dt,
                b.getF().y() / b.getM() * dt
        );
    }

    public static Dot.Coords dp(Dot b, long dt, Dot.Coords dv) {
        return new Dot.Coords(
                (b.getV().x() + dv.x() / 2) * dt,
                (b.getV().y() + dv.y() / 2) * dt
        );
    }
}
