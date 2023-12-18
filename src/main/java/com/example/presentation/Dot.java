package com.example.presentation;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Dot {
    private double m;
    private ObjectProperty<Coords> p;
    private Coords v;
    private Coords f;

    public Dot(Coords xyCoords, double mass) {
        if (mass < Dots.MIN_BODY_MASS || mass > Dots.MAX_BODY_MASS) {
            throw new RuntimeException("Body mass of bound");
        }
        m = mass;
        p = new SimpleObjectProperty<>(xyCoords);
        v = new Coords(0.0, 0.0);
        f = new Coords(0.0, 0.0);
    }

    public Dot(Coords xyCoords, double mass, Coords v) {
        this(xyCoords, mass);
        this.v = v;
    }

    public double getM() {
        return m;
    }

    public void setM(double m) {
        this.m = m;
    }

    public Coords getP() {
        return p.get();
    }

    public ObjectProperty<Coords> pProperty() {
        return p;
    }

    public void setP(Coords p) {
        this.p.set(p);
    }

    public Coords getV() {
        return v;
    }

    public void setV(Coords v) {
        this.v = v;
    }

    public Coords getF() {
        return f;
    }

    public void setF(Coords f) {
        this.f = f;
    }

    public record Coords(double x, double y){}
}
