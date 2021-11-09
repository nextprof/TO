package com.company;

public class Polar2DAdapter implements IVector,IPolar2D{

    private Vector2D srcVector;

    public Polar2DAdapter(Vector2D srcVector) {
        this.srcVector = srcVector;
    }

    @Override
    public double getAngle() {
       double[] components = srcVector.getComponents();
       return Math.atan2(components[1],components[0]) * 180/Math.PI;
    }

    @Override
    public double abs() {
        return this.srcVector.abs();
    }

    @Override
    public double cdot(IVector iVector) {
        return this.srcVector.cdot(iVector);
    }

    @Override
    public double[] getComponents() {
        return this.srcVector.getComponents();
    }
}
