package cz.muni.fi.pb162.project.geometry;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 27. 10. 2015
 */
public class RegularOctagon extends GeneralRegularPolygon {
    public RegularOctagon(Vertex2D center, double edgeLength) {
        super(center, 8, edgeLength);
    }
}
