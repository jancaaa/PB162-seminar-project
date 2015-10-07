package cz.muni.fi.pb162.project.geometry;

/**
 *
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 7.10.2015
 *
 */
public class Vertex2D {
    private double X;
    private double Y;

    public double getX() {
        return X;
    }

    public void setX(double newX) {
        X = newX;
    }

    public double getY() {
        return Y;
    }

    public void setY(double newY) {
        Y = newY;
    }

    @Override
    public String toString() {
        return "["+ X + ", " + Y + "]";
    }
}
