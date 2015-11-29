package cz.muni.fi.pb162.project.geometry;

/**
 * @author: Jana Zahradnickova,  UCO 433598
 * @version: 9. 11. 2015
 */
public class ArrayPolygon extends SimplePolygon {
    private Vertex2D[] vertices;

    public ArrayPolygon(Vertex2D[] array) {
        this.vertices = new Vertex2D[array.length];
        System.arraycopy(array, 0, this.vertices, 0, array.length);
    }

    @Override
    public Vertex2D getVertex(int index) throws IllegalArgumentException {
        if (index < 0)
            throw new IllegalArgumentException("Index<0!");
        else
            return vertices[index % getNumVertices()];
    }

    @Override
    public int getNumVertices() {
        return vertices.length;
    }

    /**
     * Invert ArrayPolygon's vertices (change their order)
     *
     * @return ArrayPolygon with inverted vertices
     */
    public ArrayPolygon invert() {
        Vertex2D[] invertedVertices = new Vertex2D[getNumVertices()];
        double x;
        double y;
        for (int i = 0; i < getNumVertices(); i++) {
            x = this.vertices[getNumVertices() - 1 - i].getX();
            y = this.vertices[getNumVertices() - 1 - i].getY();
            invertedVertices[i] = new Vertex2D(x, y);
        }
        return new ArrayPolygon(invertedVertices);
    }

    /**
     * Tests if polygons are the same alike meaning they have the same coordinates of vertices in the same or inverted order
     *
     * @param pol - Array polygon to be tested
     * @return true - polygons are the same, false - polygons are not the same
     */
    public boolean compare(ArrayPolygon pol) {
        if (getNumVertices() != pol.getNumVertices())
            return false; //different number of vertices

        for (int i = 0; i < getNumVertices(); i++) {
            if (testSimilarity(pol, i))
                return true;
        }

        ArrayPolygon invertedPolygon = pol.invert();

        for (int i = 0; i < getNumVertices(); i++) {
            if (testSimilarity(invertedPolygon, i))
                return true;
        }
        return false;
    }

    /**
     * Tests if two polygons are the same
     *
     * @param pol Array polygon to be tested
     * @param offset
     * @return true - polygons are the same, false - polygons are not the same
     */
    private boolean testSimilarity(ArrayPolygon pol, int offset) {
        for (int i = 0; i < getNumVertices(); i++) {
            if (!((vertices[i].getX() == pol.getVertex(i + offset).getX()) && (vertices[i].getY() == pol.getVertex(i + offset).getY()))) {
                return false;
            }
        }
        return true;
    }
}