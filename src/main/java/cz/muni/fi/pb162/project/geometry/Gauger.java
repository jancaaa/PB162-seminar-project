package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 21. 10. 2015
 *
 */

/**
 *  Gauger
 */
public class Gauger { //meridlo

    public static void printMeasurement(Measurable measurable) {
        System.out.println(measurable.toString());
        System.out.println("Length/Perimeter: " + measurable.getLength());
  }

    public static void printMeasurement(Solid solid) {
        printMeasurement((Measurable)solid);
        System.out.println("Area: " + solid.getArea());
    }
}
