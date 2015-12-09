package cz.muni.fi.pb162.project.geometry;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 7.10.2015
 */

import java.util.Objects;

/**
 * Represents vertex [X,Y]
 */
public class Vertex2D implements Comparable<Vertex2D> {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vertex2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * calculates the distance between the current and the specified vertex
     *
     * @param vert - the second vertex
     * @return distance distance between the current and the specified vertex
     */
    public double distance(Vertex2D vert) {
        if (vert == null)
            return -1.0;
        else

            return Math.sqrt(Math.pow(vert.getX() - this.getX(), 2) + Math.pow((vert.getY() - this.getY()), 2));
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //same adress

        if (o == null || getClass() != o.getClass()) return false; //different types
        Vertex2D vertex2D = (Vertex2D) o;
        return Objects.equals(x, vertex2D.x) &&
                Objects.equals(y, vertex2D.y);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public int compareTo(Vertex2D o) {
        if (this.getX() - o.getX() == 0.0)
            return (int) Math.signum(this.getY() - o.getY());
        else
            return (int) Math.signum(this.getX() - o.getX());
    }
}
