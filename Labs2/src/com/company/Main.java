package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        PolarInheritance2D vector2D = new PolarInheritance2D(5,5);
        Vector3DDecorator vector3DDecorator = new Vector3DDecorator(5,10,15);
        Vector3DInheritance vector3DInheritance = new Vector3DInheritance(5,3,2);


        System.out.print("wspolrzedne kartezjanskie");
        System.out.println(" " + Arrays.toString(vector2D.getComponents()));
        System.out.print("wspolrzedne biegunowe");
        System.out.println(" " + vector2D.getAngle() + " moduł " + vector2D.abs());


        System.out.print("wspolrzedne kartezjanskie");
        System.out.println(" " + Arrays.toString(vector3DDecorator.getComponents()));
        System.out.print("wspolrzedne biegunowe");
        Polar2DAdapter polar2DAdapter = new Polar2DAdapter((Vector2D) vector3DDecorator.getSrcV());
        System.out.println(" " + polar2DAdapter.getAngle()+ " moduł " + vector3DDecorator.abs());


        System.out.print("wspolrzedne kartezjanskie");
        System.out.println(" " + Arrays.toString(vector3DInheritance.getComponents()));
        System.out.print("wspolrzedne biegunowe");
        System.out.println(" " + new Polar2DAdapter(vector3DInheritance).getAngle() + " moduł " + vector3DInheritance.abs());


        System.out.println();
        System.out.println("Wektor 1 i 2");
        System.out.println("Iloczyn skalarny " + vector2D.cdot(vector3DDecorator));
        System.out.println("Iloczyn wektorowy " + Arrays.toString(vector3DDecorator.cross(vector2D).getComponents()));

        System.out.println("Wektor 2 i 3");
        System.out.println("Iloczyn skalarny " + vector3DDecorator.cdot(vector3DInheritance));
        System.out.println("Iloczyn wektorowy " + Arrays.toString(vector3DDecorator.cross(vector3DInheritance).getComponents()));

        System.out.println("Wektor 1 i 3");
        System.out.println("Iloczyn skalarny " + vector2D.cdot(vector3DInheritance));
        System.out.println("Iloczyn wektorowy " + Arrays.toString(vector3DInheritance.cross(vector2D).getComponents()));
    }
}
