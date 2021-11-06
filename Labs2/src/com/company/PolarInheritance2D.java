package com.company;

public class PolarInheritance2D extends Vector2D{
    public PolarInheritance2D(double x, double y) {
        super(x, y);
    }

    public double getAngle() {
        double[] components = super.getComponents();
        return Math.atan2(components[1],components[0]) * 180/Math.PI;
    }
}
