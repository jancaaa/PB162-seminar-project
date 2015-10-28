package cz.muni.fi.pb162.project.geometry;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 14. 10. 2015
 */

/**
 * Represents circle (S,r).
 */
public class Circle extends GeneralRegularPolygon implements Solid{

    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle() {
        this(new Vertex2D(0, 0), 1);
    }

    public Circle(Vertex2D center, double radius) {
        super(center,Integer.MAX_VALUE,0);
        this.radius = radius;
    }

    @Override
    public String toString() {
        Vertex2D center = getCenter();
        return "Circle: center=[" + center.getX() + ", " + center.getY() + "], radius=" + getRadius();
    }

    @Override
    public double getArea() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public double getLength() { //obvod
        return 2 * Math.PI * getRadius();
    }
}
