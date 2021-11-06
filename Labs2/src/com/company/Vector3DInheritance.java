package com.company;

public class Vector3DInheritance extends Vector2D{
    private final double z;

    public Vector3DInheritance(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public double abs() {
        return super.abs();
    }

    @Override
    public double cdot(IVector iVector) {
        double[] firstVectorComponents = getComponents();
        double[] secondVectorComponents = iVector.getComponents();

        return firstVectorComponents[0] * secondVectorComponents[0] +
                firstVectorComponents[1] * secondVectorComponents[1] +
                firstVectorComponents[2] * secondVectorComponents[2];
    }

    @Override
    public double[] getComponents() {
        double[] components = super.getComponents();
        return new double[] {components[0], components[1], z};
    }

    public Vector3DInheritance cross(IVector iVector) {
        double[] firstVectorComponents = getComponents();
        double[] secondVectorComponents = iVector.getComponents();

        double a = firstVectorComponents[1] * secondVectorComponents[2] - z * secondVectorComponents[1];
        double b = z * secondVectorComponents[0] - firstVectorComponents[0] * secondVectorComponents[2];
        double c = firstVectorComponents[0] * secondVectorComponents[1] - firstVectorComponents[1] * secondVectorComponents[0];

        return new Vector3DInheritance(a,b,c);
    }

    public IVector getSrcV() {
        double[] vectorComponents = getComponents();
        return new Vector2D(vectorComponents[0],vectorComponents[1]);
    }


}
