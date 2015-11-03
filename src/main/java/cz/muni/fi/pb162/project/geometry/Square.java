package cz.muni.fi.pb162.project.geometry;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 28. 10. 2015
 */
public class Square extends GeneralRegularPolygon {
    public Square(Vertex2D center, double edgeLength) {
        super(center, 4, edgeLength);
    }

    public Square(double radius, Vertex2D center) {
        super(center, 4, Math.sqrt(2 * radius * radius));
    }
}
