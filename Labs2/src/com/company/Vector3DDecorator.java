package com.company;

public class Vector3DDecorator implements IVector{

    private final IVector srcVector;
    private final double z;

    public Vector3DDecorator(double x, double y,double z) {
        srcVector = new Vector2D(x,y);
        this.z = z;
    }

    @Override
    public double abs() {
        double[] srcVectorComponents = srcVector.getComponents();
        return Math.sqrt(Math.pow(srcVectorComponents[0],2) + Math.pow(srcVectorComponents[1],2) + Math.pow(z,2));
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
        double[] components = srcVector.getComponents();
        return new double[] {components[0], components[1], z};
    }


    public IVector getSrcV() {
        return srcVector;
    }

    public Vector3DDecorator cross(IVector iVector) {
        double[] firstVectorComponents = getComponents();
        double[] secondVectorComponents = iVector.getComponents();

        double a = firstVectorComponents[1] * secondVectorComponents[2] - z * secondVectorComponents[1];
        double b = z * secondVectorComponents[0] - firstVectorComponents[0] * secondVectorComponents[2];
        double c = firstVectorComponents[0] * secondVectorComponents[1] - firstVectorComponents[1] * secondVectorComponents[0];

        return new Vector3DDecorator(a,b,c);
    }

}
