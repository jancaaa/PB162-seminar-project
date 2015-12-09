package cz.muni.fi.pb162.project.geometry;

import java.util.Comparator;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 9. 12. 2015
 */
public class VertexInverseComparator implements Comparator<Vertex2D> {
    @Override
    public int compare(Vertex2D o1, Vertex2D o2) {
        return -o1.compareTo(o2);
    }
}
