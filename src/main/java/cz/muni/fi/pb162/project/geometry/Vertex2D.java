package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 7.10.2015
 *
 */

/**
 * Represents vertex [X,Y]
 */

public class Vertex2D {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public void setX(double newx) {
        this.x = newx;
    }

    public double getY() {
        return y;
    }

    public void setY(double newy) {
        this.y = newy;
    }

    @Override
    public String toString() {
        return "["+ x + ", " + y + "]";
    }
}
